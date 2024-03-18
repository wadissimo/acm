package atcoder.dp;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class L_Deque {
    Long[][] dp;
    int[] a;
    long go(int i, int j){
        if(i==j)
            return a[i];
        if(dp[i][j] != null)
            return dp[i][j];
        long res = Math.max(a[i]-go(i+1, j), a[j]-go(i, j-1));
        dp[i][j] = res;
        return res;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();

        a = in.na(n);
        dp = new Long[n][n];
        long ans = go(0, n-1);
        out.println(ans);
    }
}
