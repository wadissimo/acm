package codeforces.g2;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] c = in.na(n);
        int max  = 0;
        for (int i = 0; i < n; i++) {
            if(i > 0){
                if(c[i] != c[0])
                    max = Math.max(max, i);
            }
            if(i < n-1){
                if(c[i] != c[n-1]){
                    max = Math.max(max, n-1-i);
                }
            }
        }
        out.println(max);
    }
}
