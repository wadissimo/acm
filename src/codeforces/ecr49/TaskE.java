package codeforces.ecr49;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskE {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(); int k = in.ni();
        long mod = 998244353 ;
        long[][] dp1 = new long[n+1][n+1];// dp1[n][len] n contains at least one len
        long[][] sum = new long[n+1][n+1];
        dp1[0][0] = 1;
        for (int len = 1; len <= n; len++) {
            dp1[len][len] = 1;
            for (int i = len+1; i <= n ; i++) {
                dp1[i][len] = dp1[i-1][len];
            }
        }
        long ans = 0;

        for (int len = 1; len <=n && len < k; len++) {
            long[] dp = new long[n+1];
            for (int pos = 0; pos < n - len + 1; pos++) {
                //dp[0] += dp1[pos][len][0]*dp1[n-pos-len][len-1][0]%mod;
                //System.out.println(dp1[pos][len][0]*dp1[n-pos-len][len-1][0]);
            }
            System.out.printf("len =%d dp[0]=%d%n", len, dp[0]);
            dp[0] %= mod;
            for (int i = 1; i <= n ; i++) {
                for (int j = i; j > 0; j--) {
                    if(j*len < k){
                        dp[i] += dp[i-j];
                    }
                }
                dp[i] %= mod;

            }
            ans = (ans+dp[n])%mod;
        }
        out.println((ans)%mod);

    }
}
