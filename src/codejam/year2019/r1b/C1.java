package codejam.year2019.r1b;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class C1 {
    int[] calc(int[] a, int[] b, int K, boolean left){
        int n = a.length;
        int[] res = new int[n];
        int[] stVal = new int[n];
        int[] stIdx = new int[n];
        int si = 0;
        TreeMap<Integer, Integer> bleft = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            while(si > 0 && (stVal[si-1] < a[i] || left && stVal[si-1] <= a[i]))
                si--;
            int l = -1;
            if(si > 0)
                l = stIdx[si-1];
            while(!bleft.isEmpty() && bleft.firstKey() < b[i])
                bleft.pollFirstEntry();
            Map.Entry<Integer, Integer> higherEntry = bleft.higherEntry(a[i] + K);
            int from = -1;
            if(higherEntry != null)
                from = higherEntry.getValue();
            Map.Entry<Integer, Integer> ceilingEntry = bleft.ceilingEntry(a[i] - K);
            int to = i-1;
            if(ceilingEntry != null)
                to = ceilingEntry.getValue();
            from = Math.max(from, l);
            to = Math.max(to, l);

            res[i] = to-from;

            bleft.put(b[i], i);
            stVal[si] = a[i];
            stIdx[si++] = i;
        }
        return res;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni(), k = in.ni();
            int[] a = in.na(n);
            int[] b = in.na(n);

            int[] rota = new int[n];
            int[] rotb = new int[n];
            for (int i = 0; i < n; i++) {
                rota[n-i-1] = a[i];
                rotb[n-i-1] = b[i];
            }
            int[]left = calc(a,b,k,true);
            int[]right = calc(rota,rotb,k,false);
            long ans = 0;
            System.out.println("t = " + t);
            for (int i = 0; i < n; i++) {
                if(b[i] > a[i] + k)
                    continue;
                long ll = b[i] >= a[i]-k?1:0;
                System.out.print("ll = " + ll);
                System.out.print(" left[i] = " + left[i]);
                System.out.println(" right[i] = " + right[i]);
                ans += (left[i] + ll)*(right[i] + ll);
            }

//            long cnt = 0;
//            for (int l = 0; l < n; l++) {
//                int am = 0;
//                int bm = 0;
//                for (int r = l; r < n; r++) {
//                    am = Math.max(am, a[r]);
//                    bm = Math.max(bm, b[r]);
//                    if(Math.abs(am-bm) <= k)
//                        cnt++;
//                }
//            }
            out.printf("Case #%d: %d%n", t+1, ans);
        }
    }
}
