package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class r363A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int INF = 1_000_000;
        int n = in.ni();
        int[] a = in.na(n);
        int[][] dp = new int[n+1][3];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = INF;
            }
        }
        dp[0][0] = 1;
        if(a[0] == 1)
            dp[0][1] = 0;
        else if(a[0] == 2)
            dp[0][2] = 0;
        else if(a[0] == 3)
            dp[0][1] = dp[0][2] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                dp[i][0] = Math.min(dp[i][0], dp[i-1][j]+1);
            }
            if(a[i] == 1){
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]);
            } else if(a[i] == 2)
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]);
            else if(a[i] == 3){
                dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]);
                dp[i][2] = Math.min(dp[i-1][0], dp[i-1][1]);
            }
        }
        int ans = INF;
        for (int i = 0; i < 3; i++) {
            ans = Math.min(dp[n-1][i], ans);
        }
        out.println(ans);
    }
}
