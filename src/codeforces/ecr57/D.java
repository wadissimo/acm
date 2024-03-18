package codeforces.ecr57;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        int[]a = in.na(n);
        long[] h = new long[n];
        long[] ha = new long[n];
        long[] har = new long[n];
        long[] hard = new long[n];
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(i>0){
                h[i] = h[i-1];
                ha[i] = ha[i-1];
                har[i] = har[i-1];
                hard[i] = hard[i-1];
            }
            if(c == 'h'){
                h[i] += a[i];
            } else if(c == 'a'){
                ha[i] = Math.min(ha[i]+a[i], h[i]);
            } else if(c == 'r'){
                har[i] = Math.min(har[i]+a[i], ha[i]);
            } else if(c == 'd'){
                hard[i] = Math.min(hard[i]+a[i], har[i]);
            }
        }
        out.println(hard[n-1]);
    }

}
