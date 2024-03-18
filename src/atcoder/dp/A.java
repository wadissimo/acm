package atcoder.dp;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] h = in.na(n);
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < n-1; i++) {
            dp[i+1] = Math.min(dp[i+1], dp[i] + Math.abs(h[i] - h[i+1]));
            if(i < n-2)
                dp[i+2] = Math.min(dp[i+2], dp[i] + Math.abs(h[i] - h[i+2]));
        }
        out.println(dp[n-1]);
    }
}
