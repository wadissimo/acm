package codeforces.r447;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.math.BigInteger;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.nl(), m = in.nl();
        int k = in.ni();
        long mod = (int)1e9+7;
        if(k == -1 && m%2 != n%2){
            out.println(0);
            return;
        }
        if(n==1 || m == 1){
            if(k==1){
                out.println(1);
            } else {
                if(n%2 == 1 && m%2 == 1){
                    out.println(1);
                } else
                    out.println(0);
            }
        } else {
            //long pow = (n-1)%(mod-1)*((m-1)%(mod-1))%(mod-1);
            BigInteger pow = BigInteger.valueOf(n).subtract(BigInteger.ONE).multiply(BigInteger.valueOf(m).subtract(BigInteger.ONE));
            long ans = BigInteger.valueOf(2).modPow(pow, BigInteger.valueOf(mod)).longValue();
            //long ans = IntegerUtils.pow(2, pow, mod)%mod;
            out.println(ans);

        }
    }
}
