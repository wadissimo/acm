package codejam.year2019.r1b;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni(), k = in.ni();
            int[] a = in.na(n);
            int[] b = in.na(n);
            long cnt = 0;
            for (int l = 0; l < n; l++) {
                int am = 0;
                int bm = 0;
                for (int r = l; r < n; r++) {
                    am = Math.max(am, a[r]);
                    bm = Math.max(bm, b[r]);
                    if(Math.abs(am-bm) <= k)
                        cnt++;
                }
            }
            out.printf("Case #%d: %d%n", t+1, cnt);
        }
    }
}
