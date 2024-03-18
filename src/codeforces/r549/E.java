package codeforces.r549;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni(), q = in.ni();
        int[] p = in.na(n);
        int[] a = in.na(m);
        int[] next = new int[n];
        for (int i = 0; i < n-1; i++) {
            next[p[i]] = p[i+1];
        }
        next[p[n-1]] = p[0];
        int[] best = new int[n];
        int[] end = new int[n];
        int[] prev = new int[n];
        Arrays.fill(prev, -1);
        int[] sol = new int[m];
        for (int i = m-1; i >= 0 ; i--) {
            int num = a[i];
            if(best[next[num]] == 0){
                best[num] = 1;
                end[num] = i;
            } else {

            }

        }
    }
}
