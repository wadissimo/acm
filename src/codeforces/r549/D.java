package codeforces.r549;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.ni(), k = in.ni();
        long a = in.ni(), b = in.ni();
        long nk = n*k;
        long x = Long.MAX_VALUE;
        long y = 0;
        for (int i = 0; i <= n+2; i++) {
            long l = a + b + k*i;
            long ans = nk/ IntegerUtils.gcd(nk, l);
            x = Math.min(x, ans);
            y = Math.max(y, ans);

            l = a - b + k*i;
            if(l > 0) {
                ans = nk / IntegerUtils.gcd(nk, l);
                x = Math.min(x, ans);
                y = Math.max(y, ans);
            }

            l = b - a + k * i;
            if(l > 0) {
                ans = nk / IntegerUtils.gcd(nk, l);
                x = Math.min(x, ans);
                y = Math.max(y, ans);
            }

            l = - a - b  + k*i;
            if(l > 0) {
                ans = nk / IntegerUtils.gcd(nk, l);
                x = Math.min(x, ans);
                y = Math.max(y, ans);
            }
        }
        out.print(x + " " + y);
    }
}
