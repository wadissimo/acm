package codeforces.ecr61;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class C2 {
    class Seg{
        int l, r;

        public Seg(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), q = in.ni();
        Seg[] seg = new Seg[q];
        for (int i = 0; i < q; i++) {
            seg[i] = new Seg(in.ni(), in.ni());
        }
        Arrays.sort(seg, (seg1, t1) -> {
            if(seg1.l == t1.l)
                return Integer.compare(seg1.r, t1.r);
            else
                return Integer.compare(seg1.l, t1.l);
        });

        int[][] prev = new int[n+1][3];
        int[][] cur = new int[n+1][3];
        for (Seg s : seg) {
            for(int x = n; x > 0; x--){
                for (int skip = 0; skip < 3; skip++) {
                    if(x > s.r || x < s.l)
                        cur[x][skip] = prev[x][skip];
                    else {
                        //todo:
                    }
                }

            }
        }

    }
}
