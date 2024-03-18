package atcoder.dp;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class I_Coins {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        double[] p = new double[n];
        for (int i = 0; i < n; i++) {
            p[i] = Double.parseDouble(in.ns());
        }
        double[][] dp = new double[n+1][n+1];
        dp[0][0] = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i+1][j] = dp[i][j]*(1-p[i]);
                if(j > 0)
                    dp[i+1][j] += dp[i][j-1]*p[i];
            }
        }
        double ans = 0;
        for (int i = 0; i < (n+1)/2; i++) {
            ans += dp[n][n-i];
        }
        out.println(ans);

    }
}
