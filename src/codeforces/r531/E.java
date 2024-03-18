package codeforces.r531;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.HashSet;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        HashMap<Integer, Integer> lastMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            lastMap.put(a[i], i);
        }
        int cnt = 0;
        int end = 0;
        for (int i = 0; i < n; i++) {
            int last = lastMap.get(a[i]);
            if(last > i){
                end = Math.max(end, last);
            }
            if(end <= i){
                cnt ++;
            }
        }

        out.println(BigInteger.valueOf(2).modPow(BigInteger.valueOf(cnt-1), BigInteger.valueOf(998244353)).toString());
    }
}
