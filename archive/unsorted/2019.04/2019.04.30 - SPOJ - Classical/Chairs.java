package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class Chairs {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni(), K = in.ni();
        long mod = (int)1e9+3;
        long[][][][] dp = new long[2][2][N+1][K+1]; // first last occupied
        dp[0][0][0][0] = dp[1][1][0][1] = 1;
        for (int i = 1; i < N; i++) {
            for(int k = K; k>= 0; --k){
                if(k < K) {
                    dp[1][1][i][k + 1] = (dp[1][1][i][k + 1] + dp[1][0][i-1][k]) % mod;
                    dp[0][1][i][k + 1] = (dp[0][1][i][k + 1] + dp[0][0][i-1][k]) % mod;
                }
                dp[1][0][i][k] = (dp[1][0][i-1][k] + dp[1][1][i-1][k])%mod;
                dp[0][0][i][k] = (dp[0][0][i-1][k] + dp[0][1][i-1][k])%mod;
            }
        }
        long ans = dp[1][0][N-1][K] + dp[0][0][N-1][K] + dp[0][1][N-1][K];
        ans %= mod;
        out.println(ans);

    }
}
