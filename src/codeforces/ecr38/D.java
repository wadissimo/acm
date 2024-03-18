package codeforces.ecr38;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.*;

public class D {
    class Edge{
        int from , to;
        long w;

        public Edge(int from, int to, long w) {
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }
    long[] vals;
    long[] a;
    List<Edge>[] g;
    class Vertex{
        int v;
        long val;

        public Vertex(int v, long val) {
            this.v = v;
            this.val = val;
        }
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();

        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            int from = in.ni()-1, to = in.ni()-1;
            long w = in.nl();
            g[from].add(new Edge(from, to, w));
            g[to].add(new Edge(to, from, w));
        }
        a = in.nal(n);
        long[] best = new long[n];
        PriorityQueue<Vertex> pq = new PriorityQueue<>(new Comparator<Vertex>() {
            @Override
            public int compare(Vertex o1, Vertex o2) {
                return Long.compare(o1.val, o2.val);
            }
        });
        for (int i = 0; i < n; i++) {
            pq.offer(new Vertex(i, a[i]));
            best[i] = a[i];
        }
        boolean[] used = new boolean[n];
        while(pq.size() != 0){
            Vertex v = pq.poll();
            if(used[v.v] || best[v.v] < v.val)
                continue;
            used[v.v] = true;
            for(Edge e: g[v.v]){
                if(!used[e.to]){
                    if(v.val + 2*e.w < best[e.to]){
                        best[e.to] = v.val + 2*e.w;
                        pq.offer(new Vertex(e.to, best[e.to]));
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(best[i] + " ");
        }
        out.println();


    }
}
