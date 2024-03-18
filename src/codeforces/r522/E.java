package codeforces.r522;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int maxSum = n*100;
        int[][][] dp = new int[n+1][maxSum + 1][n+1];
        dp[0][0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int sum = 0; sum <= maxSum ; sum++) {
                for (int k = 0; k <= n; k++) {
                    if(dp[i-1][sum][k] != 0){
                        dp[i][sum][k] += dp[i-1][sum][k];
                        if(k < n)
                            dp[i][sum+a[i-1]][k+1] += dp[i-1][sum][k];
                    }
                }
            }
        }
        int[] freq = new int[101];
        for (int i = 0; i < n; i++) {
            freq[a[i]]++;
        }
        int ans = 0;
        for (int i = 1; i < 101; i++) {
            if(freq[i] > 0){
                for (int k = freq[i]; k > 0 ; k--) {
                    if(dp[n][i*k][k] == 1){
                        ans = Math.max(ans, k);
                        break;
                    }
                }
            }
        }
        out.println(ans);

    }
}
