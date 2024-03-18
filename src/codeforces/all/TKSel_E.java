package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TKSel_E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        byte[] a = new byte[n];
        for (int i = 0; i < n; i++) {
            a[i] = (byte)in.ni();
        }

        int max = 100;
        int[] cnt = new int[max+1];
        for (int i = 0; i < n; i++) {
            cnt[a[i]]++;
        }
        int ncnt = 0;
        for (int i = 1; i <= max; i++) {
            if(cnt[i] > 0)
                ncnt++;
        }
        if(ncnt <= 2){
            out.println(n);
            return;
        }
        byte[][][] dp = new byte[max][max+2][max*max+3];//dp[i][k][sum]
        dp[0][1][a[0]] = a[0];
        for (int i = 1; i < n; i++) {
            dp[i][1][a[i]] = a[i];
            for (int k = i; k >= 1; k--) {
                for (int sum = 1; sum <= max * max; sum++) {
                    if(dp[i-1][k][sum] != 0){
                        dp[i][k][sum] = dp[i-1][k][sum];
                        if(dp[i-1][k][sum] == a[i] && (dp[i][k+1][sum+a[i]] == 0 || dp[i][k+1][sum+a[i]] == a[i])){
                            dp[i][k+1][sum+a[i]] = a[i];
                        } else {
                            dp[i][k+1][sum+a[i]] = -1; // different nums
                        }
                    }

                }

            }
        }

        int ans = 0;
        for (int i = 1; i <= max; i++) {
            if(cnt[i] > 0){
                int sum = 0;
                for (int j = 1; j <= cnt[i]; j++) {
                    sum +=i;
                    if(dp[n-1][j][sum] == i){
                        ans = Math.max(ans, j);
                    } // else break
                }
            }
        }
        out.println(ans);
    }
}
