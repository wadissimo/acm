package atcoder.dp;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;

public class O_Matching {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long mod = (int)1e9 +7;
        int n = in.ni();
        int[][] g = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = in.ni();
            }
        }

        long [] dp = new long[1<<n];
        dp[0] = 1;
        LinkedList<Integer>[] masks = new LinkedList[n+1];
        for (int i = 0; i < n+1; i++) {
            masks[i] = new LinkedList<>();
        }
        for (int i = 0; i < 1 << n; i++) {
            masks[Integer.bitCount(i)].add(i);
        }
        for (int i = 0; i < n; i++) {
            for (int mask : masks[i]) {
                for (int j = 0; j < n; j++) {
                    if(g[i][j] == 1 && (mask&(1<<j)) == 0){
                        dp[mask|(1<<j)] = (dp[mask|(1<<j)]+dp[mask])%mod;
                    }
                }
            }

        }

        out.println(dp[(1<<n)-1]);
    }
}
