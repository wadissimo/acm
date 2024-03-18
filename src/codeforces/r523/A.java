package codeforces.r523;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), s = in.ni();
        int ans = s/n;
        if(s%n != 0) ans++;
        out.println(ans);
    }
}
