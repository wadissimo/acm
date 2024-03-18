package codeforces.hcc2018;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class C2 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni(), p = in.ni();
        int[] a = in.na(n);
        long[][] cur = new long[k][p];
        for (int i = 0; i < k; i++) {
            Arrays.fill(cur[i], -1);
        }
        long[][] nxt = new long[k][p];
        for (int i = 0; i < k; i++) {
            Arrays.fill(nxt[i], -1);
        }
        cur[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int kk = 0; kk < k; kk++) {
                for (int pp = 0; pp < p; pp++) {
                    if(cur[kk][pp] != -1) {
                        nxt[kk][(pp+a[i])%p] = Math.max(nxt[kk][(pp+a[i])%p], cur[kk][pp]-pp + (pp+a[i])%p);
                        if(i>0 && kk < k-1){
                            nxt[kk+1][a[i]%p] = Math.max(nxt[kk+1][a[i]%p], cur[kk][pp] + a[i]%p);
                        }
                    }
                }
            }
            long[][] tmp = cur;
            cur = nxt;
            nxt = tmp;
            for (int ii = 0; ii < k; ii++) {
                Arrays.fill(nxt[ii], -1);
            }
        }
        long ans = 0;
        for (int pp = 0; pp < p; pp++) {
            ans = Math.max(ans, cur[k-1][pp]);
        }
        out.println(ans);
    }
}
