package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class A3 {
    class Interval{
        long from, to;
        long p;
        long h;

        public Interval(long from, long to, long h) {
            this.from = from;
            this.to = to;
            this.h = h;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int N = in.ni(), K = in.ni();
            long[] l = new long[N];
            for (int i = 0; i < K; i++) {
                l[i] = in.ni();
            }
            long AL = in.ni(), BL = in.ni(), CL = in.ni(), DL = in.ni();
            long[] w = new long[N];
            for (int i = 0; i < K; i++) {
                w[i] = in.ni();
            }
            long AW = in.ni(), BW = in.ni(), CW = in.ni(), DW = in.ni();

            long[] h = new long[N];
            for (int i = 0; i < K; i++) {
                h[i] = in.ni();
            }
            long AH = in.ni(), BH = in.ni(), CH = in.ni(), DH = in.ni();
            for (int i = K; i < N; i++) {
                l[i] = (AL * l[i - 2] + BL * l[i - 1] + CL) % DL + 1;
                w[i] = (AW * w[i - 2] + BW * w[i - 1] + CW) % DW + 1;
                h[i] = (AH * h[i - 2] + BH * h[i - 1] + CH) % DH + 1;
            }

            // solution
            long ans = 1;
            long MOD = 1_000_000_007;
            TreeMap<Long, Interval> tree = new TreeMap<>();
            long totalP = 0;
            for (int i = 0; i < N; i++) {
                long right = l[i] + w[i];
                long left = l[i];
                LinkedList<Interval> intersection = null;
                while (!tree.isEmpty()) {
                    Map.Entry<Long, Interval> entry = tree.floorEntry(right);
                    if (entry == null || entry.getValue().to < left)
                        break;
                    if (intersection == null)
                        intersection = new LinkedList<>();
                    intersection.addFirst(entry.getValue());
                    tree.remove(entry.getKey());
                }

                if (intersection == null) {
                    Interval cur = new Interval(left, right, h[i]);
                    cur.p = 2 * (h[i] + w[i]);
                    totalP += cur.p;
                    tree.put(left, cur);
                } else {
                    long prevP = 0;
                    long newP = (w[i]+h[i])*2;
                    Interval first = intersection.getFirst();
                    Interval last = intersection.getLast();
                    prevP += 2*(first.h+first.to-first.from);
                    if(first.from < left){
                        prevP -= first.h;
                        prevP -= (left-first.from)*2;
                        tree.put(first.from, new Interval(first.from, left, first.h));
                        newP -= first.h;
                    }
                    Interval prev = first;
                    intersection.removeFirst();
                    for (Interval interval : intersection) {
                        prevP += (interval.h + interval.to - interval.from)*2;
                        if(interval.from == prev.to){
                            prevP -= 2*Math.min(prev.h, interval.h);
                        }
                        prev = interval;
                    }
                    if(last.to > right){
                        prevP-= last.h;
                        prevP -= (last.to-right)*2;
                        tree.put(right, new Interval(right, last.to, last.h));
                        newP -= last.h;
                    }
                    totalP -= prevP;
                    totalP += newP;

                    Interval cur = new Interval(left, right, h[i]);
                    tree.put(left, cur);

                }
                ans = (ans * (totalP % MOD)) % MOD;

            }
            out.printf("Case #%d: %d%n", t + 1, ans);
        }
    }
}
