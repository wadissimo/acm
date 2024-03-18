package codeforces.r446;

import chelper.io.FastScanner;
import common.DSU;

import java.io.PrintWriter;
import java.util.*;

public class E {
    class Edge{
        int id;
        int from, to, w;

        public Edge(int id, int from, int to, int w) {
            this.id = id;
            this.from = from;
            this.to = to;
            this.w = w;
        }
    }
    class Pair implements Comparable<Pair>{
        int a,b;

        public Pair(int a, int b) {
            this.a = Math.min(a,b);
            this.b = Math.max(a,b);
        }


        @Override
        public int compareTo(Pair pair) {
            if(this.a == pair.a)
                return Integer.compare(this.b, pair.b);
            else
                return Integer.compare(this.a, pair.a);
        }
    }
    List<Integer>[] g;
    boolean[] used;
    boolean dfs(int v, int p){
        for (int u : g[v]) {
            if(u == p)
                continue;
            if(used[u])
                return false;
            used[u] = true;
            if(!dfs(u, v))
                return false;
        }
        return true;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();

        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();//LinkedList is faster
        }
        used = new boolean[n];
        int MAX_W = 500_007;
        int[] sizesByW = new int[MAX_W];
        Edge[][] edges = new Edge[MAX_W][];
        Edge[] edgeArray = new Edge[m];
        for (int i = 0; i < m; i++) {
            int from = in.ni()-1, to = in.ni()-1, w = in.ni();
            sizesByW[w]++;
            Edge e1 = new Edge(i, from, to, w);
            edgeArray[i] = e1;
        }

        int[][] byW = new int[MAX_W][];
        int[] edgeCnts = new int[MAX_W];
        for (int i = 0; i < MAX_W; i++) {
            byW[i] = new int[sizesByW[i]];
            edges[i] = new Edge[sizesByW[i]];
        }
        for (int i = 0; i < m; i++) {
            int w = edgeArray[i].w;
            edges[w][edgeCnts[w]++] = edgeArray[i];
        }


        //MST
        DSU dsu = new DSU(n);
        boolean[] good = new boolean[m];
        Pair[] connections = new Pair[m];
        for (int w = 0; w < MAX_W; w++) {
            if(edges[w] == null)
                continue;
            for (int i = 0; i < sizesByW[w]; i++) {
                Edge edge = edges[w][i];
                if(dsu.find(edge.from) != dsu.find(edge.to)){
                    good[edge.id] = true;
                    connections[edge.id] = new Pair(dsu.find(edge.from), dsu.find(edge.to));
                }
            }
            for (int i = 0; i < sizesByW[w]; i++) {
                Edge edge = edges[w][i];
                if(dsu.find(edge.from) != dsu.find(edge.to)){
                    dsu.union(edge.from, edge.to);
                }
            }
        }


        int[] cntByW = new int[MAX_W];
        boolean[]qdW = new boolean[MAX_W];
        int[]qd = new int[MAX_W];
        int qdi;
        int[]ids = new int[MAX_W];

        int[] vertices = new int[MAX_W];
        int vi;
        boolean[] usedVertices = new boolean[MAX_W];

        int Q = in.ni();

        for (int q = 0; q < Q; q++) {
            int k = in.ni();
            boolean allGood = true;
            for (int kk = 0; kk < k; kk++) {
                ids[kk] = in.ni()-1;
                if(!good[ids[kk]])
                    allGood = false;
            }
            if(!allGood){
                out.println("NO");
                continue;
            }
            qdi = 0;
            for (int kk = 0; kk < k; kk++) {
                int w = edgeArray[ids[kk]].w;
                if(!qdW[w]) {
                    qdW[w] = true;
                    qd[qdi++] = w;
                }
                byW[w][cntByW[w]++] = ids[kk];
            }
            boolean isTree = true;
            for (int i = 0; i < qdi; i++) {
                int w = qd[i];
                if(isTree) {
                    vi = 0;
                    TreeSet<Pair> pairs = new TreeSet<>();
                    //try to build a tree(forest)
                    for (int j = 0; j < cntByW[w]; j++) {
                        int idx = byW[w][j];
                        if (connections[idx] == null)
                            throw new RuntimeException();
                        Pair pair = connections[idx];
                        if (pairs.contains(pair)) { // double edge
                            isTree = false;
                            break;
                        }
                        pairs.add(pair);
                        g[pair.a].add(pair.b);
                        g[pair.b].add(pair.a);

                        if(!usedVertices[pair.a]){
                            usedVertices[pair.a] = true;
                            vertices[vi++] = pair.a;
                        }
                        if(!usedVertices[pair.b]){
                            usedVertices[pair.b] = true;
                            vertices[vi++] = pair.b;
                        }
                    }
                    //check if it's a forest
                    if (isTree) {
                        for (int j = 0; j < vi; j++) {
                            if (!used[vertices[j]]) {
                                if (!dfs(vertices[j], -1)) {
                                    isTree = false;
                                    break;
                                }
                            }
                        }
                    }

                    //clear the tree
                    for (int j = 0; j < vi; j++) {
                        int v = vertices[j];
                        usedVertices[v] = false;
                        used[v] = false;
                        g[v].clear();
                    }
                }
                cntByW[w] = 0;
                qdW[w] = false;
            }
            if(isTree)
                out.println("YES");
            else
                out.println("NO");
        }
    }
}
