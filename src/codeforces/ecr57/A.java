package codeforces.ecr57;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int a = in.ni(), b = in.ni();
            out.printf("%d %d%n", a, 2*a);
        }
    }
}
