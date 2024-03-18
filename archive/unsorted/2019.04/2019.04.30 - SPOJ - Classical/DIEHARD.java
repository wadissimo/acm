package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class DIEHARD {
    Integer[][][] dp;
    int go(int cur, int h, int a){
        if(dp[cur][h][a] != null)
            return dp[cur][h][a];
        int steps = 0;
        if(cur != 0){
            steps = Math.max(steps, 1 + go(0, h+3, a+2));
        }
        if(cur != 1 && h > 5 && a > 10)
            steps = Math.max(steps, 1 +  go(1, h-5, a-10));
        if(cur != 2 && h > 20)
            steps = Math.max(steps, 1 +  go(2, h-20, a+5));

        return dp[cur][h][a] = steps;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int h = in.ni(), a = in.ni();
            dp = new Integer[3][2000][2000];
            int res = go(1, h, a);
            out.println(res);

        }
    }
}
