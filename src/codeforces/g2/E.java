package codeforces.g2;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int rem = 0;
        long made = 0;
        for (int i = 0; i < n; i++) {
            if(rem == 0){
                made += a[i] / 3;
                rem = a[i]%3;
            } else {
                if(a[i] >= rem*2){
                    made+= rem;
                    a[i] -= rem*2;
                    made += a[i] /3;
                    rem = a[i]%3;
                } else {
                    rem -= a[i]/2;
                    made += a[i]/2;
                    rem += a[i]%2;
                }
            }
        }
        out.println(made);
    }
}
