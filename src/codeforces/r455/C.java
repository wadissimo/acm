package codeforces.r455;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        char[] s = new char[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.readLine().charAt(0);
        }
        long mod = (long)1e9+7;
        long[][] dp = new long[n+1][n+1];
        dp[0][0] = 1;
        for (int i = 1; i < n ; i++) {
            if(s[i-1] == 'f'){
                for (int j = 1; j < n; j++) {
                    dp[i][j] = dp[i-1][j-1];
                }
            } else {
                for (int j = n-1; j >= 0 ; j--) {
                    dp[i][j] = (dp[i][j+1] + dp[i-1][j])%mod;
                }
            }
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans = (ans + dp[n-1][i])%mod;
        }
        out.println(ans);
    }
}
