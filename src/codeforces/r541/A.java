package codeforces.r541;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int w1 = in.ni(), h1 = in.ni(), w2 = in.ni(), h2 = in.ni();
        long ans = w1 + 2*(h1 + 1) + w2 + 2*(h2 + 1);
        if(w1 != w2)
            ans+=w1-w2;
        out.println(ans);
    }
}
