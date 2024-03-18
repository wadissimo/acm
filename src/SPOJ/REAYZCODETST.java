package SPOJ;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

public class REAYZCODETST {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni();
            long x = in.nl();
            int []a = in.na(n);
            HashMap<Long, Integer> set = new HashMap<>();
            long ans = 0;
            for (int i = 0; i < n; i++) {
                Integer cnt = set.get((a[i] + x));
                if(cnt != null) {
                    ans+=cnt;
                }
                cnt = set.get((a[i] - x));
                if(cnt != null) {
                    ans+=cnt;
                }
                cnt = set.get((long)a[i]);
                if(cnt == null){
                    set.put((long)a[i], 1);
                } else{
                    set.put((long)a[i], cnt +1);
                }
            }
            out.println("Case "+(t+1)+": "+ans);
        }
    }
}
