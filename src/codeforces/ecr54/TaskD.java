package codeforces.ecr54;

import chelper.io.FastScanner;
import common.G;
import common.GraphUtil;
import common.GraphUtil.Edge;

import java.io.PrintWriter;
import java.util.*;

public class TaskD {
    class Pair{
        long w;
        int v;

        public Pair(long w, int v) {
            this.w = w;
            this.v = v;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long INF = 1234567890123456789L;
        int n = in.ni(), m = in.ni(), k = in.ni();
        List<Edge>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            int from = in.ni()-1, to = in.ni()-1, w = in.ni();
            g[from].add(new Edge(from, to, i, w));
            g[to].add(new Edge(to, from, i, w));
        }
        G graph = new G(g);
        G.Dijkstra dijkstra = graph.dijkstra();
        Edge[] p = new Edge[n];
        dijkstra.dijkstra(new long[n], p);
        List<Edge>[] tree = new List[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new LinkedList<>();
        }
        for (int i = 1; i < n; i++) {
            Edge e = p[i];
            tree[e.from].add(e);
        }
        boolean[] keep = new boolean[m];
        int[] queue = new int[n];
        int qi = 0;
        queue[qi++] = 0;
        boolean[] used = new boolean[n];
        used[0] = true;
        int size = 0;
        for (int i = 0; i < qi && k > 0; i++) {
            int v = queue[i];
            for (Edge e : tree[v]) {
                if(!used[e.to]){
                    k--;
                    //System.out.printf("%d %d %d %d%n", e.id, e.from, e.to, e.w);
                    keep[e.id] = true;
                    used[e.to] = true;
                    queue[qi++] = e.to;
                    size++;
                    if(k == 0)
                        break;
                }
            }
        }
        out.println(size);
        for (int i = 0; i < m; i++) {
            if(keep[i]){
                out.print((i+1)+" ");
            }
        }
        out.println();
    }
}
