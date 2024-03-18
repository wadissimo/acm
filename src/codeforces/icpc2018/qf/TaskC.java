package codeforces.icpc2018.qf;

import chelper.io.InputReader;
import common.Fenwick;
import common.FenwickTree;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TaskC {
    class Interval {
        int l,r;
        long c,p;
        int pi;
        public Interval(int l, int r, int c, int p) {
            this.l = l;
            this.r = r;
            this.c = c;
            this.p = p;
        }
    }
    BigInteger findCost(ArrayList<Long> prices, Fenwick counts, Fenwick total, int l, int r, int k){
        int pn = counts.n;
        long sum = counts.get(pn-1);
        if(sum <= k){
            return BigInteger.valueOf(total.get(pn-1)).multiply(BigInteger.valueOf(r-l+1));
        } else {
            int left = 1;
            int right = pn-1;
            while (left < right) {
                int mid = (left + right) / 2;
                long cnt = counts.get(mid);
                if (cnt <= k) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            long cost = total.get(right - 1);
            long cores = counts.get(right - 1);
            return BigInteger.valueOf(cost+(prices.get(right-1))*(k-cores)).multiply(BigInteger.valueOf(r-l+1));
        }
    }
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();int k = in.ni();int m = in.ni();
        Interval[] intervals = new Interval[m];
        for (int i = 0; i < m; i++) {
            int l = in.ni(); int r = in.ni();int c = in.ni();int p = in.ni();
            intervals[i] = new Interval(l,r,c,p);
        }
        ArrayList<Long> prices = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> Long.compare(o1.p,o2.p));
        long price = 0;
        int pi = 0;
        for (Interval interval : intervals) {
            if(interval.p > price){
                prices.add(interval.p);
                price = interval.p;
                pi++;
            }
            interval.pi = pi;
        }
        int l = 1;
        Arrays.sort(intervals, (a,b)->Integer.compare(a.l,b.l));
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>((o1, o2) -> Integer.compare(o1.r, o2.r));
        int pn = prices.size();
        Fenwick tree = new Fenwick(pn +7);
        Fenwick total = new Fenwick(pn +7);
        BigInteger ans = BigInteger.ZERO;
        for (int i = 0; i < m; i++) {
            Interval interval = intervals[i];
            if(interval.l > l){
                while(pq.size() > 0 && pq.peek().r < interval.l){
                    Interval peek = pq.peek();
                    if(peek.r >= l){
                        ans = ans.add(findCost(prices, tree, total, l, peek.r, k));
                        l = peek.r+1;
                    }
                    Interval remove = pq.poll();
                    tree.add(remove.pi, -remove.c);
                    total.add(remove.pi, -remove.p*remove.c);
                }
                if(l < interval.l){
                    ans = ans.add(findCost(prices, tree, total, l, interval.l-1, k));
                }
                l = interval.l;
            }
            pq.add(interval);
            tree.add(interval.pi, interval.c);
            total.add(interval.pi, interval.p*interval.c);
        }

        while(pq.size() > 0){
            Interval peek = pq.peek();
            if(peek.r >= l){
                ans = ans.add(findCost(prices, tree, total, l, peek.r, k));
                l = peek.r+1;
            }
            Interval remove = pq.poll();
            tree.add(remove.pi, -remove.c);
            total.add(remove.pi, -remove.p*remove.c);
        }
        out.println(ans);
    }
}
