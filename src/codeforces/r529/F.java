package codeforces.r529;

import chelper.io.FastScanner;
import common.DSU;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class F {
    class Edge{
        int from, to;
        long w;

        public Edge(int from, int to, long w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        long[] a = new long[n];
        long min = Long.MAX_VALUE;
        int minv = 0;
        for (int i = 0; i < n; i++) {
            a[i] = in.nl();
            if(a[i] < min){
                minv = i;
                min = a[i];
            }
        }
        Edge[] edges = new Edge[m+n-1];
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(in.ni()-1, in.ni()-1, in.nl());
        }
        int ind = m;
        for (int i = 0; i <  n; i++) {
            if(i != minv)
                edges[ind++] = new Edge(minv, i, a[i]+a[minv]);
        }
        if(m+n > 1000){
            Random r = new Random();
            for (int i = 0; i < 1000; i++) {
                int x = r.nextInt(edges.length);
                int y = r.nextInt(edges.length-1);
                if(y>=x)
                    y++;
                Edge t = edges[x];
                edges[x] = edges[y];
                edges[y] = t;
            }
        }
        Arrays.sort(edges, Comparator.comparingLong(o -> o.w));
        DSU dsu = new DSU(n);
        long ans = 0;
        for (int i = 0; i < edges.length; i++) {
            int aa = dsu.find(edges[i].from);
            int bb = dsu.find(edges[i].to);
            if(aa != bb){
                ans += edges[i].w;
                dsu.union(aa,bb);
            }
        }
        out.println(ans);
    }
}
