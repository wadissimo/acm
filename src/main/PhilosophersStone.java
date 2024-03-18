package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class PhilosophersStone {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int H = in.ni(), W = in.ni();
            int[][] grid = in.nmi(H, W);
            int[][] dp = new int[H+1][W];
            for (int i = 0; i < H; i++) {
                for (int j = 0; j < W; j++) {
                    if(j > 0){
                        dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j-1]+grid[i][j]);
                    }
                    dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j]+grid[i][j]);
                    if(j < W-1)
                        dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j+1]+grid[i][j]);
                }
            }
            int ans = 0;
            for (int i = 0; i < W; i++) {
                ans = Math.max(ans, dp[H][i]);
            }
            out.println(ans);
        }
    }
}
