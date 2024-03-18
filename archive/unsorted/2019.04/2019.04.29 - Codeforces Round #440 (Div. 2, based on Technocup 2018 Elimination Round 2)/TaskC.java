package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int Q = in.ni();
        for (int q = 0; q < Q; q++) {
            int n = in.ni();
            if(n%4 == 0){
                out.println(n/4);
            } else if(n%4 == 1){
                if(n < 9){
                    out.println(-1);
                } else {
                    out.println((1+(n-9)/4));
                }
            } else if(n%4 == 2){
                if(n < 6){
                    out.println(-1);
                } else {
                    out.println((1+(n-6)/4));
                }
            } else if(n%4 == 3){
                if(n < 15){
                    out.println(-1);
                } else {
                    out.println((2+(n-15)/4));
                }
            }
        }
    }
}
