package atcoder.dp;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class H_Grid {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int h = in.ni(), w = in.ni();
        char[][] map = in.nm(h, w);
        long[][] dp = new long[h+1][w+1];
        long mod = (int)1e9 + 7;
        dp[0][0] = 1;
        for (int r = 0; r < h; r++) {
            for (int c = 0; c < w; c++) {
                if(map[r][c] == '.') {
                    if (r > 0) {
                        dp[r][c] += dp[r-1][c];
                    }
                    if(c > 0)
                        dp[r][c] += dp[r][c-1];
                    dp[r][c] %= mod;
                }
            }
        }
        out.println(dp[h-1][w-1]);

    }
}
