package codeforces.hcc2018;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class E2 {
    class Seg{
        int from, to;
        int d;

        public Seg(int from, int to) {
            this.from = from;
            this.to = to;
            d = to-from;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int k = in.ni(), n = in.ni();
        int[] a = in.na(n);
        if(n > 1000){
            ArrayUtils.randomShuffle(a);
        }
        Arrays.sort(a);
        Seg[] ss = new Seg[n-1];
        for (int i = 0; i < n-1 ; i++) {
            ss[i] = new Seg(a[i], a[i+1]);
        }
        if(n>1000){
            ArrayUtils.randomShuffle(ss);
        }
        Arrays.sort(ss, Comparator.comparingInt((x)->x.d));
        if(n>1000){
            Random r = new Random();
            int lim = Math.min(3*k, n-1);
            for (int i = 0; i < k; i++) {
                int x = r.nextInt(lim);
                int y = r.nextInt(lim-1);
                if(y >= x) y++;
                Seg t = ss[x];ss[x] = ss[y]; ss[y] = t;
            }
        }
        Arrays.sort(ss, 0, Math.min(3*k, n-1), Comparator.comparingInt((x)->x.from));
        int[] b = new int[Math.min(6*k, n)];

        b[0] = ss[0].from; b[1] = ss[0].to;
        int bi = 2;
        for (int i = 1; i < Math.min(3 * k, n-1); i++) {
            if(ss[i].from != ss[0].to){
                b[bi++] = ss[i].from;
            }
            b[bi++] = ss[i].to;
            ss[0] = ss[i];
        }
        long[] prev = new long[k+1];
        long[] cur = new long[k+1];
        long[] nxt = new long[k+1];
        for (int j = 0; j < k + 1; j++) {
            prev[j] = cur[j] = nxt[j] = Long.MAX_VALUE;
        }

        //System.out.println("Arrays.toString(b) = " + Arrays.toString(b));
        prev[0] = cur[0] = 0;
        long ans = Long.MAX_VALUE;
        for (int i = 1; i < bi; i++) {
            for (int kk = 0; kk < k; kk++) {
                nxt[kk] = Math.min(nxt[kk], cur[kk]);
                if(prev[kk] != Long.MAX_VALUE)
                    nxt[kk + 1] = Math.min(nxt[kk + 1], prev[kk] + b[i] - b[i - 1]);
            }
            ans = Math.min(ans, nxt[k]);
            long[] tmp = prev;
            prev = cur;
            cur = nxt;
            nxt = tmp;
            for (int j = 0; j < k + 1; j++) {
                nxt[j] = nxt[j] = Long.MAX_VALUE;
            }
        }
        out.println(ans);
    }
}
