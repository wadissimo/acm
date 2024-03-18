package codeforces.r449;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int k = in.ni(), p = in.ni();
        long ans = 0;
        for (int i = 1; i <= k; i++) {
            String s = Integer.toString(i);
            s = s + new StringBuilder().append(s).reverse();
            long l = Long.parseLong(s);
            ans = ans + l%p;
            ans %=p;
        }
        out.println(ans);
    }
}
