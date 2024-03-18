package atcoder.dp;

import chelper.io.FastScanner;
import common.GraphUtil;

import java.io.PrintWriter;
import java.util.List;

public class P_IndependentSet {
    List<GraphUtil.Edge>[] graph;
    long[] dpw;
    long[] dpb;
    boolean[] used;
    long mod = (int)1e9+7;
    void dfs(int v) {
        dpw[v] = dpb[v] = 1;
        for (GraphUtil.Edge edge : graph[v]) {
            int u = edge.to;
            if(!used[u]){
                used[u] = true;
                dfs(u);
                dpb[v] = dpb[v] * dpw[u] %mod;
                dpw[v] = dpw[v] * (dpw[u] + dpb[u])%mod;
            }
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();

        graph = in.readEdgesGraph(n, n-1, true);
        dpw = new long[n];
        dpb = new long[n];
        used = new boolean[n];
        used[0] = true;
        dfs(0);
        out.println((dpw[0] + dpb[0])%mod);

    }
}
