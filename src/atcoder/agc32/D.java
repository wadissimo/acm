package atcoder.agc32;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class D {
    Long [][] memo;
    boolean[][] first;
    boolean[][] last;
    int a;
    int b;
    long best;
    private long rec(int from, int to){
        if(memo[from][to] != null)
            return memo[from][to];
        if(to-from == 1){
            if(first[from][to])
                return memo[from][to] = 0L;
            else
                return memo[from][to] = best;
        }
        if(first[from][to])
            return memo[from][to] = rec(from+1, to);
        else if(last[from][to])
            return memo[from][to] = rec(from, to-1);
        return memo[from][to] = Math.min(rec(from+1, to)+b, rec(from, to-1)+a);
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        a = in.ni();
        b = in.ni();
        best = Math.min(a,b);


        int[] p = new int[n];
        int[] pinv = new int[n];
        for (int i = 0; i < n; i++) {
            p[i] = in.ni()-1;
            pinv[p[i]] = i;
        }
        if(n == 1){
            out.println(0);
            return;
        }

        first = new boolean[n][n];

        last = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if(pinv[j] < pinv[i])
                    break;
                first[i][j] = true;
            }
        }
        for (int i = n-1; i >= 0 ; i--) {
            for (int j = i-1; j >= 0 ; j--) {
                if(pinv[j] > pinv[i])
                    break;
                last[j][i] = true;
            }
        }
        memo = new Long[n][n];
        long[][] dp = new long[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
        }
        for (int i = 0; i < n-1; i++) {
            if(!first[i][i+1])
                dp[i][i+1] = best;
            else
                dp[i][i+1] = 0;
        }
        for (int len = 2; len < n; len++) {
            for (int i = 0; i+len < n; i++) {
                if(first[i][i+len])
                    dp[i][i+len] = dp[i+1][i+len];
                else if(last[i][i+len])
                    dp[i][i+len] = dp[i][i+len-1];
                else
                    dp[i][i+len] = Math.min(dp[i][i+len-1]+a, dp[i+1][i+len]+b);
            }
        }
        long ans = dp[0][n-1];
        out.println(ans);
        System.out.println("rec(0,n-1) = " + rec(0, n - 1));
    }
}
