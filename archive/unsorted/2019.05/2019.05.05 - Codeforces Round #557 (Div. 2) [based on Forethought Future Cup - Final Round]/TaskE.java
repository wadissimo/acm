package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskE {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int min = 100;
        for (int i = 0; i < n; i++) {
            min = Math.min(min, a[i]);
        }
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] == min)
                cnt++;
        }
        if(cnt <= n/2){
            out.println("Alice");
        } else{
            out.println("Bob");
        }
    }
}
