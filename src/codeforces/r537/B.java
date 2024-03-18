package codeforces.r537;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Random;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni(), m = in.ni();
        long[] a = in.nal(n);
        long max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i]);
        }
        int mcnt = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] == max)
                mcnt++;
        }

        Random r = new Random();
        if(n>1000){
            for (int i = 0; i < n / 2; i++) {
                int x = r.nextInt(n);
                int y = r.nextInt(n-1);
                if(y>=x) y++;
                long t = a[x];
                a[x] = a[y];
                a[y] = t;
            }
        }
        Arrays.sort(a);
        long [] pref = new long[n+1];
        for (int i = 0; i < n; i++) {
            pref[i+1] = pref[i] + a[i];
        }

        BigDecimal ans = BigDecimal.ZERO;
        for (int i = 0; i < Math.min(n, m+1); i++) {
            long sum = Math.min(k*(long)(n-i), (m-i)) + pref[n]-pref[i];//delete i
            BigDecimal bd = BigDecimal.valueOf(sum).divide(BigDecimal.valueOf(n-i), 10, BigDecimal.ROUND_HALF_UP);
            if(bd.compareTo(ans) > 0){
                ans = bd;
            }
        }
        out.println(ans.toString());

    }
}
