package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class r4895C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long INF = 1_000_000_000_000L;
        int n = in.ni();
        int[] s = in.na(n);
        int[] c = in.na(n);
        long[][] dp = new long[4][n];
        for (int i = 0; i < 4; i++) {
            Arrays.fill(dp[i], INF);
        }
        for (int i = 0; i < n; i++) {
            dp[1][i] = c[i];
            for (int j = 2; j < 4; j++) {
                for (int k = 0; k < i; k++) {
                    if(s[k] < s[i])
                        dp[j][i] = Math.min(dp[j][i], dp[j-1][k]);
                }
                if(dp[j][i] != INF)
                    dp[j][i] += c[i];
            }
        }
        long ans = INF;
        for (int i = 0; i < n; i++) {
            ans = Math.min(ans, dp[3][i]);
        }
        if(ans == INF)
            out.println(-1);
        else
            out.println(ans);
    }
}
