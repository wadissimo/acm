package codejam.year2008.r1a;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni();
            int[] a = in.na(n);
            int[] b = in.na(n);
            Arrays.sort(a);Arrays.sort(b);
            long res = 0;
            for (int i = 0; i < n; i++) {
                res += a[i]*b[n-i-1];
            }
            out.printf("Case #%d: %d%n", t+1, res);
        }
    }
}
