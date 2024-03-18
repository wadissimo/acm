package codeforces.r544;

import chelper.io.FastScanner;
import common.GraphUtil;

import java.io.PrintWriter;
import java.util.List;

public class F1 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        List<GraphUtil.Edge>[] g = in.readEdgesGraph(n, m, true);
        int maxDegree = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            if(g[i].size() > maxDegree){
                maxDegree = g[i].size();
                max = i;
            }
        }
        boolean[] used = new boolean[n];
        used[max] = true;
        int[] st = new int[n+m];
        int sti = 0;
        for (GraphUtil.Edge edge : g[max]) {
            st[sti++] = edge.to;
            used[edge.to] = true;
            out.printf("%d %d%n", max+1, edge.to+1);
        }
        while(sti > 0){
            int v = st[--sti];
            for (GraphUtil.Edge edge : g[v]) {
                if(!used[edge.to]){
                    used[edge.to] = true;
                    st[sti++] = edge.to;
                    out.printf("%d %d%n", v+1, edge.to+1);
                }
            }
        }
    }
}
