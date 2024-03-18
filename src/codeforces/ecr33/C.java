package codeforces.ecr33;

import chelper.io.FastScanner;
import common.GraphUtil;

import java.io.PrintWriter;
import java.util.List;

public class C {
    int[] c;
    List<GraphUtil.Edge>[] g;
    boolean[] used;
    int dfs(int v){
        int best = c[v];
        for (GraphUtil.Edge e : g[v]) {
            if(!used[e.to]){
                used[e.to] = true;
                best = Math.min(best, dfs(e.to));
            }
        }
        return best;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        c = in.na(n);
        g = in.readEdgesGraph(n, m, true);
        used = new boolean[n];
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if(used[i])
                continue;
            sum += dfs(i);
        }
        out.println(sum);

    }
}
