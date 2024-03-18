package atcoder.dp;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[][] a = new int[n][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                a[i][j] = in.ni();
            }
        }
        int[][] dp = new int[n+1][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if(j != k){
                        dp[i+1][j] = Math.max(dp[i+1][j], dp[i][k] + a[i][j]);
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < 3; i++) {
            max = Math.max(max, dp[n][i]);
        }
        out.println(max);

    }
}
