package atcoder.beginner.r124;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int a = in.ni(), b = in.ni();
        out.println(Math.max(a +b, Math.max(2*a-1, 2*b-1)));
    }
}
