package atcoder.dp;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), W = in.ni();
        int[] w = new int[n];
        int[] v = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = in.ni();
            v[i] = in.ni();
        }
        long[][] dp = new long[n+1][100_007];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int i = 0; i < n; i++) {
            for (int vv = 0; vv < 100_007; vv++) {
                if(dp[i][vv] < Long.MAX_VALUE) {
                    dp[i + 1][vv] = Math.min(dp[i + 1][vv], dp[i][vv]);
                    if (vv + v[i] < 100_007)
                        dp[i + 1][vv + v[i]] = Math.min(dp[i + 1][vv + v[i]], dp[i][vv] + w[i]);
                }
            }
        }
        for (int vv = 100_001; vv >= 0; vv--) {
            if(dp[n][vv] <= W){
                out.println(vv);
                return;
            }
        }

    }
}
