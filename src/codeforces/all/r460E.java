package codeforces.all;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.math.BigInteger;

public class r460E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int a = in.ni(), b = in.ni(), p = in.ni();
        long x = in.nl();
        long[] invs = IntegerUtils.invs(p, p);
        long ainv = BigInteger.valueOf(a).modPow(BigInteger.valueOf(p-2), BigInteger.valueOf(p)).longValue();
        long ar = 1;
        long[] cnt = new long[p];
        long ans = 0;
        int am = BigInteger.valueOf(a).modPow(BigInteger.valueOf(x/p), BigInteger.valueOf(p)).intValue();
        for (int r = 0; r < p; r++) {
            int num = (int)(invs[r]*ar%p*b%p);
            cnt[num]++;
            if(r<=x%p && am == num){
                ans++;
            }
            ar = ar*ainv%p;
        }
        long m = x/p;
        if(m > 0) {
            m--;
            long k = m / (p - 1);
            int t = (int) (m % (p - 1));
            ans += k * (p - 1);
            long at = 1;
            for (int i = 0; i <= t; i++) {
                ans += cnt[(int) (at)];
                at = at * a % p;
            }
        }
        out.println(ans);

    }
}
