package codeforces.ecr59;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int q = in.ni();
        for (int i = 0; i < q; i++) {
            long k = in.nl();
            int x = in.ni();
            long ans = x + 9*(k-1);
            out.println(ans);
        }
    }
}
