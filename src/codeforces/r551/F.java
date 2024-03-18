package codeforces.r551;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.math.BigInteger;

public class F {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni(), l = in.ni();
        int mod = 998244353;
        long[] invs = IntegerUtils.invs(2 * n+3, mod);
        long[][] p = new long[2*n+1][n+1];
        p[0][1] = 1; // first is always started
        long ans = 0;
        for (int i = 1; i < 2 * n; i++) {
            int prevMaxRunning = Math.min(2*n-i, i); // how many intervals max were running (covering)
            int maxRunning = Math.min(2*n-i-1, i+1); // how many intervals max can be running
            for (int j = 0; j <=prevMaxRunning; j++) {
                if(p[i-1][j] != 0){
                    if(j > 0){
                        p[i][j-1] = (p[i][j-1] + p[i-1][j]*j%mod*invs[2*n-i]%mod)%mod; // close an interval
                    }
                    if(j < maxRunning){
                        p[i][j+1] = (p[i][j+1] + p[i-1][j]*(2*n-i-j)%mod*invs[2*n-i]%mod)%mod; // start a new interval
                    }
                    if(j >= k)
                        ans = (ans + p[i-1][j])%mod;
                }
            }
        }
        if(k <= 1)
            ans += p[2*n-1][1];

        ans = ans*l%mod*invs[2*n+1]%mod;
        out.println(ans);
    }
}
