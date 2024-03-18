package codeforces.r446;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        long[] gcds = new long[n];
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] == 1)
                cnt1++;
            gcds[i] = a[i];
        }
        if(cnt1 > 0){
            out.println(n-cnt1);
            return;
        }
        for (int len = 2; len <= n; len++) {
            boolean found = false;
            for (int i = 0; i <= n-len; i++) {
                gcds[i] = IntegerUtils.gcd(a[i], gcds[i+1]);
                if(gcds[i] == 1){
                    found = true;
                    break;
                }
            }
            if(found){
                out.println(n-1 + len-1);
                return;
            }
        }
        out.println(-1);
    }
}
