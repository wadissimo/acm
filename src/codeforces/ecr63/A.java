package codeforces.ecr63;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        for (int i = 1; i < n; i++) {
            if(s.charAt(i) < s.charAt(i-1)){
                out.println("YES");
                out.println((i) + " "+ (i+1));
                return;
            }
        }
        out.println("NO");
    }
}
