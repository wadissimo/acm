package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class r240B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        long mod = (int)1e9+7;
        long[][]dp = new long[k][n+1];
        for (int i = 1; i <= n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < k; i++) {
            for (int j = 1; j <= n; j++) {
                for (int l = 1; l <=n && l*j <= n; l++) {
                    dp[i][l*j] = (dp[i][l*j]+dp[i-1][j])% mod;
                }
            }
        }
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = (ans + dp[k-1][i])%mod;
        }
        out.println(ans);
        
    }
}
