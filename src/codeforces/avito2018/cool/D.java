package codeforces.avito2018.cool;

import chelper.io.FastScanner;
import common.DSU;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;

public class D {
    class Edge{
        int u, v, w;

        public Edge(int u, int v, int w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni(), k = in.ni();
        int[] x = new int[k];
        int[] xind = new int[n];
        Arrays.fill(xind, -1);
        for (int i = 0; i < k; i++) {
            x[i] = in.ni()-1;
            xind[x[i]] = i;
        }
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            edges[i] = new Edge(in.ni()-1, in.ni()-1, in.ni());
        }
        Arrays.sort(edges, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return Integer.compare(o1.w, o2.w);
            }
        });
        int[] cnt = new int[n];
        for (int i = 0; i < k; i++) {
            cnt[x[i]] = 1;
        }
        DSU dsu = new DSU(n);
        int ans = 0;
        for (int i = 0; i < m; i++) {
            Edge e = edges[i];
            if(dsu.find(e.u) == dsu.find(e.v))
                continue;
            int cu = cnt[dsu.find(e.u)];
            int cv = cnt[dsu.find(e.v)];
            if(cu+cv == k){
                ans = e.w;
                break;
            }
            dsu.union(e.u, e.v);
            cnt[dsu.find(e.u)] = cu+cv;
        }
        for (int i = 0; i < k; i++) {
            out.print(ans + " ");
        }
        out.println();


    }
    class DSU {
        int[] rank, parent;
        int n;

        public DSU(int n) {
            rank = new int[n];
            parent = new int[n];
            this.n = n;
            makeSet();
        }

        void makeSet() {
            for (int i=0; i<n; i++) {
                parent[i] = i;
            }
        }

        public int find(int x) {
            if (parent[x]!=x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int xRoot = find(x), yRoot = find(y);
            if (xRoot == yRoot)
                return;
            if (rank[xRoot] < rank[yRoot])
                parent[xRoot] = yRoot;
            else if (rank[yRoot] < rank[xRoot])
                parent[yRoot] = xRoot;
            else {
                parent[yRoot] = xRoot;
                rank[xRoot] = rank[xRoot] + 1;
            }
        }

    }
}
