package atcoder.tenka1;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.Arrays;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        long mod = 998244353;
        int[] a = in.na(n);
        int p = 0;
        for (int i = 0; i < n; i++) {
            p += a[i];
        }
        int p2 = p/2+1;
        long[][] dp = new long[n+1][p2+1];
//        for (int i = 0; i < n; i++) {
//            Arrays.fill(dp[i], -1);
//        }
        dp[0][0] = 1;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int k = i; k >= 0; k--) {
                for (int j = p / 2 - a[i]; j >= 0; j--) {
                    if (dp[k][j] != 0) {
                        dp[k + 1][j + a[i]] = (dp[k][j] + dp[k + 1][j + a[i]]) % mod;
                    }
                }
            }
            max += a[i];
        }
        long ans = 0;
        for (int i = 1; i <=n-2; i++) {
            for (int j = 1; j <=p2 ; j++) {
                if(dp[i][j] != 0){
                    System.out.print("i = " + i);
                    System.out.print(" j = " + j);
                    System.out.println(" dp[i][j] = " + dp[i][j]);
                    ans = (ans + dp[i][j]*(IntegerUtils.pow(2, n-i, mod)-2) + mod)%mod;
                }
            }
        }
        out.println(ans);
    }
}
