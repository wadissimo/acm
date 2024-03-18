package codeforces.r531;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.nl();
        long sum = n*(n+1)/2;
        out.println(sum%2);
    }
}
