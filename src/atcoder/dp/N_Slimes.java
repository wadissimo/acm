package atcoder.dp;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class N_Slimes {
    long[] a;
    Long[][] dp;
    long [] pref;
    long go(int i, int j){
        if(i==j){
            return 0;
        }
        if(dp[i][j] != null)
            return dp[i][j];
        dp[i][j] = pref[j+1]-pref[i];
        long cost = Long.MAX_VALUE;
        for (int k = i; k < j; k++) {
            cost = Math.min(go(i, k) + go(k+1, j), cost);
        }
        dp[i][j] += cost;
        return dp[i][j];
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        a = in.nal(n);
        dp = new Long[n][n];

        pref = new long[n+1];
        for (int i = 0; i < n; i++) {
            pref[i+1] = pref[i] + a[i];
        }
        go(0, n-1);
        out.println(dp[0][n-1]);
    }
}
