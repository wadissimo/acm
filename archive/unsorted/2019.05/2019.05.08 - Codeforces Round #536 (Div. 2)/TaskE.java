package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class TaskE {
    class Segment {
        int from, to, d;
        int w;

        public Segment(int from, int to, int d, int w) {
            this.from = from;
            this.to = to;
            this.d = d;
            this.w = w;
        }
    }
    class Sol{
        int d;
        long min;

        public Sol(int d, long min) {
            this.d = d;
            this.min = min;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni(), k = in.ni();
        Segment[] seg = new Segment[k];
        for (int i = 0; i < k; i++) {
            seg[i] = new Segment(in.ni()-1, in.ni()-1, in.ni()-1, in.ni());
        }
        Arrays.sort(seg, (x,y)->{
            if(x.from == y.from){
                if(x.w == y.w)
                    return -Integer.compare(x.d, y.d);
                else
                    return -Integer.compare(x.w, y.w);
            } else
                return Integer.compare(x.from, y.from);
        });
        long[][] dp = new long[m+1][n+1];
        long INF = Long.MAX_VALUE;
        for (int i = 0; i <= m ; i++) {
            Arrays.fill(dp[i], INF);
        }
        dp[0][0] = 0;
        PriorityQueue<Segment> cur = new PriorityQueue<>((x,y)->(-Integer.compare(x.w,y.w)));
        int idx = 0;
        int prev = -1;
        for (int i = 0; i < n; i++) {
            while(!cur.isEmpty() && cur.peek().to < i)
                cur.poll();
            while(idx < k && seg[idx].from <= i) {
                cur.offer(seg[idx++]);
            }
            if(cur.isEmpty())
                continue;
            Segment currentSegment = cur.peek();
            for(int mm = m; mm >= 0; mm--){
                long best = INF;
                for(int j = prev+1; j <= i; j++){
                    best = Math.min(best, dp[mm][j]);
                }
                if(best == INF)
                    continue;
                dp[mm][currentSegment.d+1] = Math.min(dp[mm][currentSegment.d+1], best + currentSegment.w);
                if(mm < m)
                    dp[mm+1][i+1] = Math.min(dp[mm+1][i+1], best);
            }
            prev = i;
        }
        long best = INF;
        for (int i = 0; i <= m; i++) {
            for (int j = prev+1; j <=n; j++) {
                best = Math.min(best, dp[i][j]);
            }
        }
        if(best == INF)
            out.println(0);
        else out.println(best);

    }
}
