package codeforces.ecr53;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        char c = s.charAt(0);
        boolean found = false;
        for (int i = 1; i < n; i++) {
            if(s.charAt(i) != c){
                out.println("YES");
                out.println(s.substring(i-1, i+1));
                return;
            }
        }
        out.println("NO");
    }
}
