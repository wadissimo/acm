package atcoder.dp;



import chelper.io.FastScanner;
import java.io.PrintWriter;

public class T_Permutation {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        long mod = (int)1e9 +7;
        long[][] dp = new long[n][n+1];
        dp[0][1] = 1;
        for (int i = 1; i < n; i++) {
            if(s.charAt(i-1) == '<') {
                long sum = 0;
                for (int j = 1; j <= i; j++) {
                    sum += dp[i - 1][j];
                    dp[i][j+1] = (dp[i][j+1]+sum)%mod;
                }
            } else {// >
                long sum = 0;
                for (int j = i; j >= 1; j--) {
                    sum += dp[i-1][j];
                    dp[i][j] = (dp[i][j]+sum)%mod;
                }
            }
        }
        long ans = 0;
        for (int i = 1; i < n + 1; i++) {
            ans += dp[n-1][i];
        }
        out.println(ans%mod);
    }
}
