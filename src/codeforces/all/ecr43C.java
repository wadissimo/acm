package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

public class ecr43C {
    class Seg{
        int id, l, r;
        public Seg(int id, int l, int r) {
            this.id = id;
            this.l = l;
            this.r = r;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        Seg[] a = new Seg[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Seg(i+1, in.ni(), in.ni());
        }
        Arrays.sort(a, new Comparator<Seg>() {
            @Override
            public int compare(Seg o1, Seg o2) {
                if(o1.r == o2.r){
                    return -Integer.compare(o1.l, o2.l);
                } else
                    return Integer.compare(o1.r, o2.r);
            }
        });
        TreeSet<Seg> tree = new TreeSet<>(new Comparator<Seg>() {
            @Override
            public int compare(Seg o1, Seg o2) {
                return -Integer.compare(o1.l, o2.l);
            }
        });
        for (Seg seg : a) {
            if(!tree.isEmpty()){
                Seg lb = tree.first();
                if(lb.l >= seg.l){
                    out.printf("%d %d%n", lb.id, seg.id);
                    return;
                }
            }
            tree.add(seg);
        }
        out.println("-1 -1");
    }
}
