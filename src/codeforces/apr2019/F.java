package codeforces.apr2019;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class F {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        String[] yes = new String[]{"NEAT", "AI", "JUROR"};
        for (int i = 0; i < yes.length; i++) {
            if(yes[i].equals(s)){
                out.println("YES");
                return;
            }
        }
        out.println("NO");  
    }
}
