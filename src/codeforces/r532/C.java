package codeforces.r532;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), R = in.ni();
        double sin = Math.sin(Math.toRadians(180.0/n));
        out.println(R*sin/(1-sin));
    }
}
