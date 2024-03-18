package atcoder.agc31;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] c = in.na(n);
        long mod = (int)1e9+7;
        int MAX = 200_001;
        long [] dp = new long[MAX];
        dp[c[0]] = 1;

        for (int i = 1; i < n; i++) {
            if(c[i] != c[i-1])
                dp[c[i]] = (dp[c[i]] + dp[c[i-1]])%mod;
        }
        out.println(dp[c[n-1]]);


    }
}
