package atcoder.dp;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class M_Candies {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        int[] a = in.na(n);
        long[][]dp = new long[n+1][k+1];
        long mod = (int)1e9+7;
        dp[0][0] = 1;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            if(sum > k) sum = k;
            long total = 0;
            for (int j = 0; j <= a[i]; j++) {
                total += dp[i][j];
                dp[i+1][j] = total%mod;
            }
            for (int j = a[i]+1; j <= sum; j++) {
                total += dp[i][j];
                total -= dp[i][j-a[i]-1];
                dp[i+1][j] = total%mod;
            }
        }
        out.println(dp[n][k]);
    }
}
