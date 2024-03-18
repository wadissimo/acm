package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class ADvaVrazhduyushchikhUchenika {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int t = in.ni();
        for (int tt = 0; tt < t; tt++) {
            int n = in.ni(), x = in.ni(), a = in.ni(), b = in.ni();
            out.println(Math.min(n-1, Math.abs(a-b)+x));
        }
    }
}
