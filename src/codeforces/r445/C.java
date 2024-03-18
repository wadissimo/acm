package codeforces.r445;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] t = in.na(n);
        boolean[] taken = new boolean[n+1];
        for (int i = 0; i < n; i++) {
            if(!taken[t[i]])
                taken[t[i]] = true;
        }
        int cnt = 0;
        for (int i = 0; i < n+1; i++) {
            if(!taken[i])
                cnt++;
        }
        out.println(cnt);
    }
}
