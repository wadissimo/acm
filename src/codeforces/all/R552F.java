package codeforces.all;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;
import java.util.Arrays;

public class R552F {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni(), k = in.ni();
        int[] a = in.na(n);
        if(n > 1000)
            ArrayUtils.randomShuffle(a);
        Arrays.sort(a);
        int[] best = new int[k+1];
        int MAX = 1_000_000_000;
        for (int i = 0; i < m; i++) {
            int x = in.ni(), y = in.ni();
            if(x <= k && y > best[x])
                best[x] = y;

        }
        long[] pref = new long[n+1];
        for (int i = 0; i < n; i++) {
            pref[i+1] = pref[i] + a[i];
        }
        long[] cur = new long[k+1];
        long[] nxt = new long[k+1];
        Arrays.fill(cur, MAX);
        Arrays.fill(nxt, MAX);
        nxt[0] = cur[0] = 0;
        for (int kk = 0; kk < k; kk++) {
            //run through all offers
            for (int i = 1; i <= k-kk; i++) {
                nxt[kk+i] = Math.min(nxt[kk+i], cur[kk] + pref[kk+i] - pref[kk+best[i]]);
            }
            //move to the next state
            System.arraycopy(nxt, 0, cur, 0, k + 1);
        }
        out.println(nxt[k]);


    }
}
