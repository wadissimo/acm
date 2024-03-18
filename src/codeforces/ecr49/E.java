package codeforces.ecr49;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), K = in.ni();
        long mod = 998244353;
        long[][] dp = new long[n+1][n+1];
        for (int lim = 1; lim <=n; lim++) {
            long sum = 1;
            dp[0][lim] = 1;
            for (int i = 1; i <= n; i++) {
                dp[i][lim] = (dp[i][lim] + sum)%mod;
                sum = (sum +dp[i][lim])%mod;
                if(i >= lim)
                    sum = (sum - dp[i-lim][lim] + mod)%mod;
            }
        }
        long ans = 0;
        for (int k = 1; k < Math.min(K, n+1); k++) {
            long h = dp[n][k]-dp[n][k-1];
            int lim = K/k;
            if(K % k == 0)
                lim--;
            if(lim > n)
                lim = n;
            ans += dp[n][lim]*h%mod;
        }
        out.println(2*ans%mod);
    }
}
