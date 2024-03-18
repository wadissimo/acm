package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int a = in.ni(), b = in.ni(), c = in.ni();
        if(n == 1){
            out.println(0);
            return;
        }
        int dist = Math.min(a,b);
        n-=2;
        int min = Math.min(dist, c);
        dist += min*n;
        out.println(dist);

    }
}
