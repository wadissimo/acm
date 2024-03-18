package atcoder.beginner.r121;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int H = in.ni(), W = in.ni();
        int h = in.ni(), w = in.ni();
        out.println(H*W-h*W-w*H+w*h);
    }
}
