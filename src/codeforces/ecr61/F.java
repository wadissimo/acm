package codeforces.ecr61;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class F {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
        }
        for (int len = 2; len < n; len++) {
            for (int i = 0; i < n - len; i++) {
                int best = len+7;
                for (int k = i; k < i+len-1 ; k++) {
                    if(s.charAt(k) == s.charAt(i+len-1)){
                        best = Math.min(best, dp[i][k] + dp[k+1][i+len-1]-1);
                    } else {
                        best = Math.min(best, dp[i][k] + dp[k+1][i+len-1]);
                    }
                }
            }
        }
        out.println(dp[0][n - 1]);


    }
}
