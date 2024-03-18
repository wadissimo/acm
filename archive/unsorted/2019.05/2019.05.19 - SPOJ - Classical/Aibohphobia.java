package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class Aibohphobia {
    int[][] dp;
    int N;
    char[] s;
    
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            s = in.ns().toCharArray();
            N = s.length;
            dp = new int[N+3][N+3];
            for (int len = 2; len <= N; len++) {
                for (int i = 0; i <= N-len; i++) {
                    if (s[i] == s[i+len-1]) {
                        dp[i][len] = dp[i+1][len-2];
                    } else {
                        dp[i][len] = Math.min(dp[i+1][len-1], dp[i][len-1]) + 1;
                    }
                }
            }
            out.println(dp[0][N]);
        }


    }
}
