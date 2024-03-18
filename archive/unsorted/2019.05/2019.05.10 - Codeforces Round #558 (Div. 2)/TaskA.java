package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        if(m == 0){
            out.println(1);
        }else if(m <= n/2){
            out.println(m);
        } else {
            out.println(n-m);
        }
    }
}
