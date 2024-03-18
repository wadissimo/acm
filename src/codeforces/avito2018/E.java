package codeforces.avito2018;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class E {
    class Event{
        int x;
        int v;
        boolean start;

        public Event(int x, int v, boolean start) {
            this.x = x;
            this.v = v;
            this.start = start;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), q = in.ni();
        int[][] qs = new int[q][];
        Event[] e = new Event[q*2];
        int ei = 0;
        for (int i = 0; i < q; i++) {
            qs[i] = new int[]{in.ni(), in.ni(), in.ni()};
            e[ei++] = new Event(qs[i][0], qs[i][2] , true);
            e[ei++] = new Event(qs[i][1], qs[i][2], false);
        }
        Arrays.sort(e, (o1, o2) -> {
            if(o1.x == o2.x){
                return -Boolean.compare(o1.start, o2.start);
            }else
                return Integer.compare(o1.x, o2.x);
        });
        long[] dp = new long[n+1];
        dp[0] = 1;
        int val;
        long mod = (int)1e9 + 7;
        boolean[] ans = new boolean[n+1];
        for (int i = 0; i < q * 2; ) {
            Event ev = e[i];
            while(i<2*q && e[i].start && e[i].x == ev.x){
                val = e[i].v;
                for (int j = n; j >= val; j--) {
                    if(dp[j-val] > 0){
                        dp[j] = (dp[j] + dp[j-val])%mod;
                    }
                }
                i++;
            }
            for (int j = 1; j <=n; j++) {
                if(dp[j] > 0)
                    ans[j] = true;
            }
            while(i < 2*q  && e[i].x == ev.x){
                val = e[i].v;
                for (int j = val; j <=n; j++) {
                    if(dp[j] > 0)
                        dp[j] = (dp[j] + mod - dp[j-val])%mod;
                }
                i++;
            }
        }
        int cnt = 0;
        for (int i = 1; i <= n; i++) {
            if(ans[i])
                cnt++;
        }
        out.println(cnt);
        for (int i = 1; i <= n; i++) {
            if(ans[i]){
                out.print(i + " ");
            }
        }


    }
}
