package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class Alphacode {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        while(true){
            String s = in.ns();
            if(s.charAt(0) == '0')
                break;
            int N = s.length();
            long[] dp = new long[N+3];
            dp[0] = 1;
            for (int i = 0; i < N; i++) {
                int d = s.charAt(i)-'0';
                if(d != 0)
                    dp[i+1] += dp[i];
                if(i < N-1) {
                    if (d == 1 || d == 2 && s.charAt(i+1) <= '6')
                        dp[i + 2] += dp[i];
                }
            }
            out.println(dp[N]);
        }
    }
}
