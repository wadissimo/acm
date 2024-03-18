package codeforces.r541;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
            b[i] = in.ni();
        }
        int x = 0, y = 0;
        long ans = 1;
        for (int i = 0; i < n; i++) {
            if(Math.min(a[i], b[i]) >= Math.max(x, y) ) {
                ans += Math.min(a[i], b[i]) - Math.max(x, y);
                if (Math.max(x, y) > Math.min(x, y))
                    ans++;
            }

            x = a[i];
            y = b[i];
        }
        out.println(ans);
    }
}
