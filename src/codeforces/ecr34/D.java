package codeforces.ecr34;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.TreeMap;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        long[] pref = new long[n+1];
        for (int i = 0; i < n; i++) {
            pref[i+1] = pref[i] + a[i];
        }
        TreeMap<Integer, Integer> counts = new TreeMap<>();

        BigInteger ans = BigInteger.ZERO;
        for (int i = 0; i < n; i++) {
            long value = (long)i*a[i] -pref[i];
            int c1 = counts.getOrDefault(a[i]+1, 0);
            int c2 = counts.getOrDefault(a[i]-1, 0);
            value += c1-c2;
            ans = ans.add(BigInteger.valueOf(value));
//            System.out.println("value = " + value);
            counts.put(a[i], counts.getOrDefault(a[i], 0)+1);
        }
        out.println(ans);
    }
}
