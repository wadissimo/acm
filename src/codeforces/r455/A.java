package codeforces.r455;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        String p = in.ns();
        char c = p.charAt(0);
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if(s.charAt(i) >= c)
                break;
            else
                sb.append(s.charAt(i));
        }
        sb.append(c);
        out.println(sb.toString());
    }
}
