package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class BeAwesomeAsBarneyStinson {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        while(true){
            int M = in.ni(), N = in.ni();
            if(M == 0)
                return;
            long [] dp = new long[N+1];
            dp[N] = 1;
            long[] next = new long[N+1];
            for (int i = 0; i < M; i++) {
                Arrays.fill(next, 0);
                int from = in.ni(), to = in.ni();
                for (int j = from; j <= to; j++) {
                    for (int k = j; k <= N; k++) {
                        if(dp[k] != 0){
                            next[k-j] += dp[k];
                        }
                    }
                }
                long[] tmp = next; next = dp; dp = tmp;
            }
            out.println(dp[0]);
        }
    }
}
