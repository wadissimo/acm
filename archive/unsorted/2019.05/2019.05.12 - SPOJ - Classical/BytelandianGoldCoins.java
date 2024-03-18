package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class BytelandianGoldCoins {
    Long[] dp;
    int MAX = 40_000_000;
    long go(int N){
        if(N == 0)
            return 0;
        if(N < MAX && dp[N] != null)
            return dp[N];
        int best = N;
        long change = go(N/2) + go(N/3) + go(N/4);
        long res = Math.max(best, change);
        if(N < MAX)
            dp[N] = res;
        return res;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        dp = new Long[MAX];
        String s = in.readLine();
        while(s != null){
            int N = Integer.parseInt(s);
            out.println(go(N));
            s = in.readLine();
        }

    }
}
