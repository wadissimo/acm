package codeforces.r537;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String v = "aeiou";
        String s = in.ns();
        String t = in.ns();
        if(s.length() != t.length()){
            out.println("No");
            return;
        }
        for (int i = 0; i < s.length(); i++) {
            if(v.indexOf(s.charAt(i)) == -1 && v.indexOf(t.charAt(i)) != -1 ||
                    v.indexOf(s.charAt(i)) != -1 && v.indexOf(t.charAt(i)) == -1){
                out.println("No");
                return;
            }
        }
        out.println("Yes");
    }
}
