package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class DancingCows {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni(), M = in.ni();
        int[] a = in.na(N);
        int[] b = in.na(M);
        Arrays.sort(a);
        Arrays.sort(b);
        long[] dp = new long[N+1];
        long INF = 1_000_000_000_000L;
        Arrays.fill(dp, INF);
        dp[0] = 0;
        for (int i = 0; i < M; i++) {
            for(int n = N-1; n >= 0;--n){
                dp[n+1] = Math.min(dp[n+1], dp[n]+Math.abs(a[n]-b[i]));
            }
        }
        out.println(dp[N]);
    }
}
