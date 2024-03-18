package atcoder.dp;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        int[] h = in.na(n);
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            for (int kk = 1; kk <= k && i+kk < n; kk++) {
                dp[i+kk] = Math.min(dp[i+kk], dp[i] + Math.abs(h[i] - h[i+kk]));
            }
        }
        out.println(dp[n-1]);
    }
}
