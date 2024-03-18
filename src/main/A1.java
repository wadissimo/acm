package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;

public class A1 {
    class Rect{
        long l,w,h;
        long p;

        public Rect(long l, long w, long h) {
            this.l = l;
            this.w = w;
            this.h = h;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int N = in.ni(), K = in.ni(), W = in.ni();
            long[] l = new long[N];
            for (int i = 0; i < K; i++) {
                l[i] = in.ni();
            }
            long AL = in.ni(), BL = in.ni(), CL = in.ni(), DL = in.ni();
            long[] h = new long[N];
            for (int i = 0; i < K; i++) {
                h[i] = in.ni();
            }
            long AH = in.ni(), BH = in.ni(), CH = in.ni(), DH = in.ni();
            for (int i = K; i < N; i++) {
                l[i] = (AL*l[i-2] + BL*l[i-1] + CL)%DL+1;
                h[i] = (AH*h[i-2] + BH*h[i-1] + CH)%DH+1;
            }

            // solution
            long ans = 1;
            long MOD = 1_000_000_007;
            LinkedList<Rect> sols = new LinkedList<>();
            for (int i = 0; i < N; i++) {
                Rect cur = new Rect(l[i], W, h[i]);

                Rect last = null;
                if(!sols.isEmpty())
                    last = sols.getLast();
                while(!sols.isEmpty() && sols.getFirst().l + W < l[i]){
                    sols.removeFirst();
                }

                if(sols.isEmpty()){
                    sols.add(cur);
                    cur.p = (W+h[i])*2L;
                    if(last != null){
                        cur.p += last.p;
                    }
                    ans = (ans*(cur.p%MOD))%MOD;
                } else {
                    Rect first = sols.getFirst();
                    while(!sols.isEmpty() && sols.getLast().h <= h[i]){
                        sols.removeLast();
                    }
                    if(sols.isEmpty()){
                        cur.p = first.p - 2L*(first.l+W-l[i]) - first.h + 2L*(h[i] + W) - first.h;
                        ans = (ans*(cur.p%MOD))%MOD;
                    } else {
                        last = sols.getLast();
                        cur.p = last.p + 2L*(l[i]-last.l);
                        ans = (ans*(cur.p%MOD))%MOD;
                    }
                    sols.addLast(cur);
                }
            }
            out.printf("Case #%d: %d%n", t+1, ans);
        }
    }
}
