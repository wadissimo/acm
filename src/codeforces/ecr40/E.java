package codeforces.ecr40;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), T = in.ni();
        int[] a = in.na(n);
        int[] t = in.na(n);
        long[] tt = new long[n];
        long sum = 0;
        long tot = 0;
        Integer[] ind = new Integer[n];
        for (int i = 0; i < n; i++) {
            ind[i] = i;
            tt[i] = t[i] - T;
        }
        Arrays.sort(ind, (x, y)->Long.compare(tt[x], tt[y]));
        for (int i = 0; i < n; i++) {
            sum += tt[i]*(long)a[i];
            tot += a[i];
        }
        if(sum == 0){
            out.println(tot);
            return;
        } else if(sum > 0) {
            for (int i = n-1; i >= 0; i--) {
                sum -= tt[ind[i]]*(long)a[ind[i]];
                tot -= a[ind[i]];
                if(sum  <= 0){
                    //x*ti + sum = 0 -> x = (-sum)/ti
                    BigDecimal bd = new BigDecimal(-sum);
                    bd = bd.divide(BigDecimal.valueOf(tt[ind[i]]), 10, BigDecimal.ROUND_HALF_UP).add(BigDecimal.valueOf(tot));
                    out.println(bd);
                    return;
                }
            }
        } else {
            for (int i = 0; i < n; i++) {
                sum -= tt[ind[i]]*(long)a[ind[i]];
                tot -= a[ind[i]];
                if(sum  >= 0){
                    BigDecimal bd = new BigDecimal(-sum);
                    bd = bd.divide(BigDecimal.valueOf(tt[ind[i]]), 10, BigDecimal.ROUND_HALF_UP).add(BigDecimal.valueOf(tot));
                    out.println(bd);
                    return;
                }
            }
        }
        out.println(0.0);
    }
}
