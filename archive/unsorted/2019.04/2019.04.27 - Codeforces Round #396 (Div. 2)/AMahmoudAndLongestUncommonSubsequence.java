package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class AMahmoudAndLongestUncommonSubsequence {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        String t = in.ns();
        if(s.equals(t))
            out.println(-1);
        else
            out.println(Math.max(s.length(), t.length()));
    }
}
