package codeforces.r515;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class TaskE {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int m = in.ni();
        String a = in.ns();
        String b = in.ns();
        BigInteger ans = BigInteger.ZERO;
        BigInteger mod = BigInteger.valueOf(998244353L);
        int[] pref = new int[m];
        for (int i = 0; i < m; i++) {
            if(i>0)
                pref[i] = pref[i-1];
            if(b.charAt(i) == '1')
                pref[i]++;
        }
        for (int i = 0; i <n; i++) {
            int bit = n-i;
            if(bit > m)
                continue;

            if(a.charAt(i) == '1') {
                int oneCount = pref[m-bit];
                BigInteger pow = BigInteger.valueOf(2).modPow(BigInteger.valueOf(bit-1), mod);
                ans = ans.add(pow.multiply(BigInteger.valueOf(oneCount)));
            }
        }
        out.println(ans.mod(mod).toString());
    }
}
