package codeforces.ecr33;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), lim = in.ni();
        int[] a = in.na(n);
        long[] money = new long[n];
        long MIN = -1_0000_000_000L;
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur+= a[i];
            money[i] = cur;
            if(cur > lim){
                out.println(-1);
                return;
            }
        }
        cur = MIN;
        long[] max = new long[n];
        for (int i = n-1; i >=0 ; i--) {
            cur = Math.max(cur, money[i]);
            max[i] = cur;
        }
        long add = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] == 0 && money[i]+add < 0){
                ans ++;
                long diff = lim-max[i]-add;
                if(money[i]+add + diff < 0){
                    out.println(-1);
                    return;
                }
                add += diff;
            }
            if(money[i]+add > lim)
                throw new RuntimeException();
        }
        out.println(ans);
    }
}
