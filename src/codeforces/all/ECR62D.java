package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class ECR62D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        if (n == 3) {
            out.println(6);
            return;
        }
        long[][] dp = new long[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        for (int len = 2; len < n - 1; len++) {
            for (int i = 0; i < n; i++) {
                int end = (i + len) % n;
                for (int mid = 1; mid < len; mid++) {
                    int m = (i + mid) % n;
                    long cur = (i + 1) * (end + 1) * (m + 1);
                    if (mid > 1) {
                        cur += dp[i][mid];
                    }
                    if (len - mid > 1) {
                        cur += dp[m][len - mid];
                    }
                    dp[i][len] = Math.min(dp[i][len], cur);
                }
            }
        }
        long best = dp[1][n - 2] + 2 * n;
        for (int len = 2; len < n - 1; len++) {
            best = Math.min(best, dp[0][len] + dp[len][n - len]);
        }
        out.println(best);
    }
}
