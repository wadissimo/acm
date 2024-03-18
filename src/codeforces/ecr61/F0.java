package codeforces.ecr61;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class F0 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        int[][][] dp = new int[n][n][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                if(j != s.charAt(i)-'a')
                    dp[i][i][j] = 1;
            }
        }
        for (int len = 1; len < n ; len++) {
            for (int i = 0; i < n - len; i++) {
                for (int j = 0; j < 26; j++) {
                    dp[i][i+len][j] = dp[i+1][i+len][j];
                    if(s.charAt(i)-'a' != j)
                        dp[i][i+len][j]++;
                }
                for (int j = 0; j < 26; j++) {
                    if(s.charAt(i+len)-'a' != j)
                        dp[i][i+len][j] = Math.min(dp[i][i+len][j], dp[i][i+len-1][j]+1);
                    else
                        dp[i][i+len][j] = Math.min(dp[i][i+len][j], dp[i][i+len-1][j]);
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            ans = Math.min(dp[0][n-1][i], ans);
        }
        out.println(ans+1);
    }
}
