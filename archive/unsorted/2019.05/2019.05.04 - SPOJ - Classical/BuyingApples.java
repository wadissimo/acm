package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class BuyingApples {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int N = in.ni(), K = in.ni();
            int[] p = in.na(K);
            int INF = 1_000_000_000;
            int[][] dp = new int[N+1][K+1];
            for (int i = 0; i <= N; i++) {
                Arrays.fill(dp[i], INF);
            }
            dp[N][K] = 0;
            for (int i = 1; i <= K; i++) {
                if(p[i-1] == -1)
                    continue;
                for(int n = N; n > 0; n--){
                    for(int k = K; k >= i; k--){
                        if(dp[n][k] != INF){
                            dp[n-1][k-i] = Math.min(dp[n-1][k-i], dp[n][k] + p[i-1]);
                        }
                    }
                }
            }
            int min = INF;
            for (int i = 0; i < N; i++) {
                min = Math.min(dp[i][0], min);
            }
            if(min == INF)
                out.println(-1);
            else
                out.println(min);
        }
    }
}
