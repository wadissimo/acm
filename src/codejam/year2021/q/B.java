package codejam.year2021.q;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int x = in.ni();
            int y = in.ni();
            String s = in.ns();
            int n = s.length();
            int[][] dp = new int[n][2];//CJ
            int INF = 1_000_000_000;
            char c = s.charAt(0);
            if(c == 'C')
                dp[0][1] = INF;
            else if(c == 'J')
                dp[0][0] = INF;
            for (int i = 1; i < n; i++) {
                c = s.charAt(i);
                if(c == 'C'){
                    dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]+y);
                    dp[i][1] = INF;
                } else if(c == 'J'){
                    dp[i][1] = Math.min(dp[i-1][1], dp[i-1][0]+x);
                    dp[i][0] = INF;
                } else if(c == '?'){
                    dp[i][0] = Math.min(dp[i-1][0], dp[i-1][1]+y);
                    dp[i][1] = Math.min(dp[i-1][1], dp[i-1][0]+x);
                }
            }
            out.printf("Case #%d: %d%n", t+1, Math.min(dp[n-1][0], dp[n-1][1]));
        }
    }
}
