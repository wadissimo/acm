package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class BlackOrWhite {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        while(true){
            int n = in.ni();
            if(n == -1)
                break;
            int[] a = in.na(n);
            int[][] dp = new int[n+1][n+1];
            for (int i = 0; i < n; i++) {
                for(int b = i; b >= 0; b--){
                    for(int w = i; w >= 0; w--){
                        if(b != 0 && b == w)
                            continue;
                        if(b == 0 || a[b-1] < a[i])
                            dp[i+1][w] = Math.max(dp[i+1][w], 1+dp[b][w]);
                        if(w == 0 || a[w-1] > a[i])
                            dp[b][i+1] = Math.max(dp[b][i+1], 1+dp[b][w]);
                    }
                }
            }
            int ans = 0;
            for (int b = 0; b <= n; b++) {
                for (int w = 0; w <= n; w++) {
                    ans = Math.max(ans, dp[b][w]);
                }
            }
            out.println(n-ans);
        }
    }
}
