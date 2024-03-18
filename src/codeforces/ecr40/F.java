package codeforces.ecr40;

import chelper.io.FastScanner;
import common.MatrixUtils;

import java.io.PrintWriter;
import java.util.Arrays;

public class F {
    class Event{
        int a;
        long x;
        long end;
        boolean start;

        public Event(int a, long x, long end, boolean start) {
            this.a = a;
            this.x = x;
            this.end = end;
            this.start = start;
        }
    }
    long mod = (int)1e9 + 7;

    long[] calc(long[] dp, boolean[] a, long cnt){
        int[][] mx = new int[3][3];
        if(a[0])
            mx[0][0] = 1;
        if(a[2])
            mx[2][2] = 1;
        if(a[1])
            mx[1][0] = mx[1][1] = mx[1][2] = mx[0][1] = mx[2][1] = 1;
        if(!a[0])
            mx[0][0] = mx[0][1] = mx[1][0] = 0;
        if(!a[2])
            mx[2][2] = mx[2][1] = mx[1][2] = 0;
        if(!a[1])
            mx[1][0] = mx[1][1] = mx[1][2] = mx[0][1] = mx[2][1] = 0;

        long[][] b = MatrixUtils.binPow(mx, cnt, mod);

        long[] res = new long[3];
        MatrixUtils.multiply(b, dp, res, mod);

        return res;
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        long m = in.nl();
        Event[] events = new Event[2*n+1];
        for (int i = 0; i < n; i++) {
            int a = in.ni()-1;
            long l = in.nl(), r = in.nl();
            events[i*2] = new Event(a, l, r+1, true);
            events[i*2+1] = new Event(a, r+1, -1, false);
        }
        events[2*n] = new Event(1, 2, -1, false);
        Arrays.sort(events, (e1, e2)->{
            if(e1.x == e2.x){
                return Boolean.compare(e1.start, e2.start);
            } else
                return Long.compare(e1.x, e2.x);
        });
        long cur = events[0].x;
        int ce = 0;
        boolean[] a = new boolean[]{true, true, true};
        long[] dp = new long[3];
        dp[1] = 1;
        long[] nxt = new long[3];
        long[] end = new long[3];
        while(cur <= m){
            while(ce < 2*n+1 && events[ce].x <= cur && !events[ce].start){
                if(end[events[ce].a] <= cur)
                    a[events[ce].a] = true;
                ce++;
            }
            while(ce < 2*n+1 && events[ce].x <= cur && events[ce].start){
                a[events[ce].a] = false;
                end[events[ce].a] = Math.max(events[ce].end, end[events[ce].a]);
                ce++;
            }
            //next
            nxt[0] = (dp[0] + dp[1])%mod;
            nxt[1] = (dp[0] + dp[1] + dp[2])%mod;
            nxt[2] = (dp[2] + dp[1])%mod;
            for (int i = 0; i < 3; i++) {
                if(!a[i]) nxt[i] = 0;
            }
            if(ce < 2*n+1){
                if(events[ce].x - cur > 1){
                    nxt = calc(nxt, a, events[ce].x - cur - 1);
                }
                cur = events[ce].x;
            } else {
               if(cur < m){
                   nxt = calc(nxt, a, m - cur);
               }
               cur = m+1;
            }
            long[] tmp = nxt; nxt = dp; dp = tmp;
        }
        out.println(dp[1]);
    }
}
