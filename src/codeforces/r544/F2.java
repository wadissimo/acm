package codeforces.r544;

import chelper.io.FastScanner;
import common.DSU;
import common.GraphUtil;

import java.io.PrintWriter;
import java.util.List;

public class F2 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni(), d = in.ni();
        List<GraphUtil.Edge>[] g = in.readEdgesGraph(n, m, true);
        if(g[0].size() < d){
            out.println("NO");
            return;
        }
        DSU dsu = new DSU(n);
        for (int i = 1; i < n; i++) {
            for (GraphUtil.Edge edge : g[i]) {
                if(edge.to != 0){
                    dsu.union(edge.from, edge.to);
                }
            }
        }
        int[] st = new int[n+m];
        int sti = 0;
        int[][] res = new int[n-1][2];
        int ri = 0;
        boolean[] usedRoot = new boolean[n];
        boolean[] used = new boolean[n];
        int must = 0;
        for (GraphUtil.Edge edge : g[0]) {
            int root = dsu.find(edge.to);
            if(!usedRoot[root]){
                res[ri++][1] = edge.to;
                used[edge.to] = true;
                usedRoot[root] = true;
                st[sti++] = edge.to;
                must++;
            }
        }
        if(must > d){
            out.println("NO");
            return;
        }
        int rem = d-must;
        for (GraphUtil.Edge edge : g[0]) {
            if(rem <= 0)
                break;
            if(!used[edge.to]){
                used[edge.to] = true;
                rem--;
                res[ri++][1] = edge.to;
                st[sti++] = edge.to;
            }
        }
        used[0] = true;
        while(sti> 0){
            int v = st[--sti];
            for (GraphUtil.Edge edge : g[v]) {
                if(!used[edge.to]){
                    used[edge.to] = true;
                    st[sti++] = edge.to;
                    res[ri][0] = v;
                    res[ri++][1] = edge.to;
                }
            }
        }
        if(ri != n-1){
            out.println("NO");
        } else {
            out.println("YES");
            for (int i = 0; i < n - 1; i++) {
                out.printf("%d %d%n", res[i][0]+1, res[i][1]+1);
            }
        }

    }
}
