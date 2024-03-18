package codeforces.avito2018.cool;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni(), k = in.ni();
        long MOD = 998244353;
        long[][] dp = new long[n+1][k+1];
        dp[1][0] = m;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = dp[i-1][j];
                if(j > 0){
                    dp[i][j] += (m-1)*dp[i-1][j-1];
                }
                dp[i][j] %= MOD;
            }
        }
        out.println(dp[n][k]);
    }
}
