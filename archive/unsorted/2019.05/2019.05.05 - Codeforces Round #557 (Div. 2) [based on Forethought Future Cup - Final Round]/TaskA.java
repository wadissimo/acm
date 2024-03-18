package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), h = in.ni(), m = in.ni();
        int[] lim = new int[n];
        Arrays.fill(lim, h);
        for (int i = 0; i < m; i++) {
            int l = in.ni()-1, r = in.ni()-1, x = in.ni();
            for (int j = l; j <=r; j++) {
                lim[j] = Math.min(lim[j], x);
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += lim[i]*lim[i];
        }
        out.println(ans);
    }
}
