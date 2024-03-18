package codeforces.gb2018;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int y = in.ni(), b = in.ni(), r = in.ni();
        b = Math.min(b, r-1);
        y = Math.min(y, b-1);
        out.println(y*3+3);
    }
}
