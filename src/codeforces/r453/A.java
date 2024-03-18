package codeforces.r453;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class A {
    class Segment{
        int from , to;

        public Segment(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        Segment[] a = new Segment[n];
        for (int i = 0; i < n; i++) {
            a[i] = new Segment(in.ni(), in.ni());
        }
        Arrays.sort(a, Comparator.comparingInt(x -> x.from));
        int limit = 0;
        for (int i = 0; i < n && limit < m; i++) {
            if(a[i].from > limit){
                out.println("NO");
                return;
            }
            limit = Math.max(limit, a[i].to);
        }
        if(limit >= m)
            out.println("YES");
        else
            out.println("NO");

    }
}
