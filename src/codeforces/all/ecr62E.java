package codeforces.all;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.math.BigInteger;

public class ecr62E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        int[] a = in.na(n);
        long mod = 998244353;
        BigInteger MOD = BigInteger.valueOf(mod);

        long[] dpSame = new long[n+1];
        long[] dpDif = new long[n+1];
        dpSame[1] = k-1;
        dpDif[1] = k-2;
        for (int i = 2; i <= n; i++) {
            dpSame[i] = (k-1)*dpDif[i-1]%mod;
            dpDif[i] = (dpSame[i-1] + (k-2)*dpDif[i-1])%mod;
        }
        long[] res = new long[2];
        boolean invalid = false;
        int start = 0;
        for (int it = 0; it < 2 && !invalid; it++) {
            int prev = -1;
            int cnt = 0;
            res[it] = 1;
            for (int i = start; i < n; i += 2) {
                if (a[i] != -1) {
                    if(prev == -1) {
                        if(cnt > 0)
                            res[it] = IntegerUtils.pow(k-1, cnt, mod);// BigInteger.valueOf(k-1).modPow(BigInteger.valueOf(cnt), MOD).longValue();
                    } else {
                        if(cnt == 0){
                            if(a[i] == a[prev]){
                                invalid = true;
                                break;
                            }
                        } else {
                            if(a[i] == a[prev]){
                                res[it] = res[it]*dpSame[cnt]%mod;
                            } else {
                                res[it] = res[it]*dpDif[cnt]%mod;
                            }
                        }
                    }
                    prev = i;
                    cnt = 0;
                } else {
                    cnt++;
                }
            }
            if(cnt > 0){
                if(prev == -1){
                    res[it] = k*IntegerUtils.pow(k-1, cnt-1, mod)%mod;//BigInteger.valueOf(k-1).modPow(BigInteger.valueOf(cnt-1), MOD).longValue()%mod;
                } else {
                    res[it] = res[it] * IntegerUtils.pow(k-1, cnt, mod)%mod;//BigInteger.valueOf(k-1).modPow(BigInteger.valueOf(cnt), MOD).longValue()%mod;
                }
            }
            start = 1;
        }

        if(invalid){
            out.println(0);
        } else {
            out.println(res[0]*res[1]%mod);
        }
    }
}
