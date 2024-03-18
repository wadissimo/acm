package codeforces.hello2019;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.nl(); int k = in.ni();
        long[] divs = new long[100];
        int dn = 0;
        int[] divCnt = new int[100];
        long orig = n;
        for(long d = 2; d*d <= n;d++){
            if(n%d == 0){
                divs[dn++] = d;
                while(n%d == 0){
                    divCnt[dn-1]++;
                    n/=d;
                }
            }
        }
        if(n!= 1){
            divs[dn++] = n;
            divCnt[dn-1] = 1;
        }
        n = orig;
        int maxCnt = 0;
        for (int i = 0; i < dn; i++) {
            maxCnt = Math.max(maxCnt, divCnt[i]);
        }
        long [] inv = new long[maxCnt+2];
        inv[1] = 1;
        long mod = 1000_000_007;
        BigInteger MOD = BigInteger.valueOf(mod);
        BigInteger M2 = MOD.subtract(BigInteger.valueOf(2));
        for (int i = 2; i <= maxCnt+1; i++) {
            inv[i] = BigInteger.valueOf(i).modPow(M2, MOD).longValue();
        }
        //System.out.println(Arrays.toString(inv));
        long ans = 1;
        for (int i = 0; i < dn; i++) {
            int cnt = divCnt[i]+1;
            long div = divs[i];
            long[][] dp = new long[k+1][cnt+1];
            dp[0][cnt] = 1;
            for (int j = 1; j <= k; j++) {
                long sum = 0;
                for (int cn = cnt; cn > 0; cn--) {
                    sum += dp[j-1][cn]*inv[cn];
                    sum %= mod;
                    dp[j][cn] = sum;
                }
            }
            long pow = 1;
            long e = 0;
            for (int j = 1; j <= cnt; j++) {
                e += pow * dp[k][j];
                e %= mod;
                pow *= div;
                pow %= mod;
            }
            //System.out.println("e = " + e);
            ans *= e;
            ans %= mod;
        }
        out.println(ans);
    }
}
