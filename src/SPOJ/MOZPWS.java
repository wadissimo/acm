package SPOJ;

import chelper.io.InputReader;
import common.SparseTable;

import java.io.PrintWriter;
import java.util.TreeMap;

public class MOZPWS {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int T = in.ni();
        int log2[] = new int[100007];
        SparseTable.preCalcLog(log2, 100007);
        for (int t = 0; t < T; t++) {
            int n = in.ni();
            int k = in.ni();
            long[] a = in.nal(n);
            TreeMap<Long, Integer> map = new TreeMap<>();
            for (int i = 0; i < k; i++) {
                map.put(a[i], map.getOrDefault(a[i], 0)+1);
            }
            long []mins = new long[n-k+1];
            mins[0] = -map.firstKey();
            for (int i = 1; i < n-k+1; i++) {
                Integer cnt = map.get(a[i - 1]);
                if(cnt == 1){
                    map.remove(a[i-1]);
                } else{
                    map.put(a[i-1], cnt-1);
                }
                map.put(a[i+k-1], map.getOrDefault(a[i+k-1], 0)+1);
                mins[i] = -map.firstKey();
            }
            SparseTable spt = new SparseTable(log2[n-k+1]+1, n-k+1, log2);
            spt.buildSparseTable(mins, n-k+1);
            out.println("Case "+(t+1) +":");
            int q = in.ni();
            for (int i = 0; i < q; i++) {
                int l = in.ni();
                int r = in.ni();
                r-=k-1;
                if(r<l){
                    out.println("Impossible");
                }else{

                    out.println(-spt.query(l-1,r-1, log2));
                }
            }
        }
    }
}
