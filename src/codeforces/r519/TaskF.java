package codeforces.r519;
import chelper.io.FastScanner;
import common.ArrayUtils;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class TaskF {

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int MAX_VAL = 300007;
        ArrayList<Integer> pr = new ArrayList<>(MAX_VAL);
        int[] lp = new int[MAX_VAL];
        IntegerUtils.sieve(MAX_VAL-5, pr, lp);
        int[][] divs = new int[MAX_VAL][10];
        int[] ndivs = new int[MAX_VAL];

        int[] count = new int[MAX_VAL];
        boolean[] res = new boolean[MAX_VAL];
        for (int i = 0; i < n; i++) {
            int[]curDivs = new int[10];
            int num = a[i];
            int ndiv = 0;
            int repl = 1;
            while(num > 1){
                int div = lp[num];
                curDivs[ndiv++] = div;
                while(num % div == 0)
                    num /= div;
                repl *= div;
            }
            a[i] = repl;
            divs[repl] = curDivs;
            ndivs[repl] = ndiv;
            res[repl] = true;
        }
        n = 0;
        for (int i = 0; i < MAX_VAL; i++) {
            if(res[i])
                a[n++] = i;
        }
        for (int i = 0; i < n; i++) {
            int[] curDivs = divs[a[i]];
            int ndiv = ndivs[a[i]];
            for (int mask = 0; mask < 1 << ndiv; mask++) {
                int num = 1;
                for (int bit = 0; bit < ndiv; bit++) {
                    if((mask & 1<<bit) != 0){
                        num *= curDivs[bit];
                    }
                }
                count[num]++;
            }
        }
        int[] curCount = new int[MAX_VAL];
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int[] curDivs = divs[a[i]];
            int k = ndivs[a[i]];

            for (int mask = (1<<k)-1; mask >= 0; mask--) {
                int num = 1;
                for (int bit = 0; bit < k; bit++) {
                    if((mask&1<<bit) != 0)
                        num *= curDivs[bit];
                }
                curCount[mask] = count[num];
                for (int smask = 0; smask < 1 << k; smask++) {
                    if((mask|smask) == smask && smask > mask) {
                        curCount[mask] -= curCount[smask];
                    }
                }
            }
            int[] dp = new int[1<<k];
            for (int j = 0; j < 1 << k; j++) {
                dp[j] = Integer.MAX_VALUE;
            }
            dp[(1<<k)-1] = 1;
            for (int mask = (1<<k)-1; mask >=0; mask--) {
                if(dp[mask] < Integer.MAX_VALUE)
                    for (int smask = 0; smask < 1 << k; smask++) {
                        if(curCount[smask] > 0)
                            dp[smask&mask] = Math.min(dp[smask&mask], dp[mask]+1);
                    }
            }
            ans = Math.min(ans, dp[0]);

        }
        if(ans == Integer.MAX_VALUE)
            ans = -1;
        out.println(ans);
    }

}
