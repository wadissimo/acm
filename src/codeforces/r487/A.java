package codeforces.r487;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        if(s.contains("ABC") || s.contains("ACB") || s.contains("BAC") || s.contains("BCA") || s.contains("CAB") || s.contains("CBA")){
            out.println("Yes");
        } else {
            out.println("No");
        }
    }
}
