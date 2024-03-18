package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class r119A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), a = in.ni(), b = in.ni(), c = in.ni();
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if(dp[i] == -1)
                continue;
            if(i+a <= n)
                dp[i+a] = Math.max(dp[i+a], dp[i]+1);
            if(i+b <= n)
                dp[i+b] = Math.max(dp[i+b], dp[i]+1);
            if(i+c <= n)
                dp[i+c] = Math.max(dp[i+c], dp[i]+1);
        }
        out.println(dp[n]);
    }
}
