package codeforces.r553;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        int best = 10000;
        char[] gen = new char[]{'A','C', 'T', 'G'};
        for (int i = 0; i < n-3; i++) {
            int cur = 0;
            for (int j = 0; j < 4 ; j++) {
                cur += Math.min(Math.abs(s.charAt(i+j)-gen[j]+26), Math.min(Math.abs(s.charAt(i+j)-gen[j]), Math.abs(gen[j]-s.charAt(i+j)+26)));

            }
            best = Math.min(cur, best);
        }
        out.println(best);

    }
}
