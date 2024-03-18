package codeforces.r554;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class D {
    long mod = (int)1e9+7;
    Long[][][] dp;
    long go(int rem, int open, int used){
        if(rem == 0)
            return 0;
        if(dp[used][rem][open] != null)
            return dp[used][rem][open];
        if(rem < open)
            throw new RuntimeException();


        if(rem == open){
            if(used == 1)
                return dp[used][rem][open] = go(rem-1, open-1, 0);
            else{
                return dp[used][rem][open] = 1 + go(rem-1, open-1, 1);
            }
        }
        if(used == 1){
            long res = 0;
            if(open > 0)
                res += go(rem-1, open-1,  0);
            res = (res +go(rem-1, open+1,  0))%mod;
            return dp[used][rem][open] = res;
        } else {
            long res = 1;//use (
            if(open > 0)
                res += go(rem-1, open-1,  0);
            res = (res +go(rem-1, open+1,  1))%mod;
            return dp[used][rem][open] = res;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        dp = new Long[2][2*n+3][2*n+3];
        out.println(go(2*n, 0, 0));
    }
}
