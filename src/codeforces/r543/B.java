package codeforces.r543;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        boolean[] c = new boolean[200_001];
        int best = 0;
        for (int sum = 2; sum < 200_000 ; sum++) {
            int res = 0;
            for (int i = 0; i < n; i++) {
                if(a[i] >= sum)
                    continue;
                if(c[sum-a[i]]){
                    res++;
                    c[sum-a[i]] = false;
                } else
                    c[a[i]] = true;
            }
            best = Math.max(best, res);
            for (int i = 0; i < n; i++) {
                c[a[i]] = false;
            }
        }
        out.println(best);
    }
}
