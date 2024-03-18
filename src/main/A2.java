package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.*;

public class A2 {
    class Interval{
        long from, to;
        long p;
        public Interval(long from, long to) {
            this.from = from;
            this.to = to;
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
                l[i] = (AL*l[i-2] + BL*l[i-1] + CL)%DL+1;
                w[i] = (AW*w[i-2] + BW*w[i-1] + CW)%DW+1;
                h[i] = (AH*h[i-2] + BH*h[i-1] + CH)%DH+1;
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
                long p = 0;
                while(!tree.isEmpty()) {
                    Map.Entry<Long, Interval> entry = tree.floorEntry(right);
                    if(entry == null || entry.getValue().to < left)
                        break;
                    if(intersection == null)
                        intersection = new LinkedList<>();
                    intersection.addFirst(entry.getValue());
                    p += entry.getValue().p;
                    tree.remove(entry.getKey());
                }
                if(intersection == null){
                    Interval cur = new Interval(left, right);
                    cur.p = 2*(h[i]+w[i]);
                    totalP += cur.p;
                    tree.put(left, cur);
                } else {
                    totalP -= p;
                    if(left < intersection.getFirst().from){
                        p += 2*(intersection.getFirst().from-left);
                    }
                    if(right > intersection.getLast().to){
                        p += 2*(right - intersection.getLast().to);
                    }
                    left = Math.min(left, intersection.getFirst().from);
                    right = Math.max(right, intersection.getLast().to);

                    if(intersection.size() > 1) {
                        Interval prev = intersection.removeFirst();
                        while(!intersection.isEmpty()){
                            Interval cur = intersection.removeFirst();
                            p += 2*(cur.from - prev.to);
                            p -= 2*h[i];
                            prev = cur;
                        }
                    }

                    Interval cur = new Interval(left, right);
                    cur.p = p;
                    tree.put(left, cur);
                    totalP += p;
                }
                ans = (ans*(totalP%MOD))%MOD;

            }
            out.printf("Case #%d: %d%n", t+1, ans);
        }
    }
}
