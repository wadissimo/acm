package codeforces.hello2019;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        String [] a = new String[5];
        for (int i = 0; i < 5; i++) {
            a[i] = in.ns();
        }
        for (int i = 0; i < 5; i++) {
            if(a[i].charAt(0) == s.charAt(0) || a[i].charAt(1) == s.charAt(1)){
                out.println("YES");
                return;
            }
        }
        out.println("NO");
    }
}
