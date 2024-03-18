package codeforces.r547;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long h = in.nl();
        int n = in.ni();
        int[] d = in.na(n);
        long delta = 0;
        long min = 0;
        for (int i = 0; i < n; i++) {
            delta += d[i];
            min = Math.min(delta, min);
        }
        long k = 0;
        if(h+min > 0){
            if(delta >= 0){
                out.println(-1);
                return;
            }
            delta *= -1;
            long m = (h + min + delta - 1) / delta;
            k = m*n;
            h -= m *delta;
        }
        for (int i = 0; i < n; i++) {
            h += d[i];
            k++;
            if(h<=0){
                out.println(k);
                break;
            }
        }
        if(h > 0)
            throw new RuntimeException("not reached 0");
    }
}
