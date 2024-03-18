package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class r462a {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int[] cnt1 = new int[n+1];
        int[] cnt2 = new int[n+1];
        for (int i = 0; i < n; i++) {
            cnt1[i+1] = cnt1[i];
            if(a[i] == 1)
                cnt1[i+1]++;
        }
        for (int i = n; i > 0; i--) {
            cnt2[i-1] = cnt2[i];
            if(a[i-1] == 2)
                cnt2[i-1]++;
        }
        int best = 0;
        for (int i = 0; i < n; i++) {
            int dp1 = 0;
            int dp2 = 0;
            for (int j = i; j < n; j++) {
                if(a[j] == 2)
                    dp2++;
                else if(a[j] == 1){
                    dp1 = Math.max(dp1+1, dp2+1);
                }
                best = Math.max(best, cnt1[i] + cnt2[j+1] + Math.max(dp1, dp2));
            }
        }
        out.println(best);
    }
}
