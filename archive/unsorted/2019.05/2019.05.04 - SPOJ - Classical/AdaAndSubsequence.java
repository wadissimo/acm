package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class AdaAndSubsequence {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni(), M = in.ni();
        int SIGMA = 26;
        int[] p = in.na(SIGMA);
        String s = in.ns();
        String t = in.ns();
        long [][] dp = new long[N+1][M+1];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(s.charAt(i) == t.charAt(j)){
                    dp[i+1][j+1] = dp[i][j]+p[s.charAt(i)-'a'];
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        out.println(dp[N][M]);
    }
}
