package codeforces.ecr54;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        int ind = -1;
        for (int i = 0; i < n-1; i++) {
            if(s.charAt(i) > s.charAt(i+1)){
                ind = i;
                break;
            }
        }
        if(ind == -1)
            out.println(s.substring(0, n-1));
        else
            out.println(s.substring(0,ind) + s.substring(ind+1));


    }
}
