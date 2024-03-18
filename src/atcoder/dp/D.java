package atcoder.dp;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), W = in.ni();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.ni();
            v[i] = in.ni();
        }
        long[][] dp = new long[n+1][W+1];
        for (int i = 0; i < n; i++) {
            for (int ww = 0; ww < W; ww++) {
                dp[i+1][ww] = Math.max(dp[i+1][ww], dp[i][ww]);
                if(ww + w[i] <= W)
                    dp[i+1][ww + w[i]] = Math.max(dp[i+1][ww + w[i]], dp[i][ww] + v[i]);
            }
        }
        long max = 0;
        for (int ww = 0; ww <= W; ww++) {
            max = Math.max(max, dp[n][ww]);
        }
        out.println(max);

    }
}
