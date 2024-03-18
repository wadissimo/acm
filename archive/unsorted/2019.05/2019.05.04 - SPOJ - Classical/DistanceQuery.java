package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class DistanceQuery {
    class Edge{
        int from, to, price;

        public Edge(int from, int to, int price) {
            this.from = from;
            this.to = to;
            this.price = price;
        }
    }
    int[] p;
    int[] cost;
    int[] d;
    List<Edge>[] g;
    int maxD = 0;
    int logD;
    int[][] jump;
    int[][] minCost;
    int[][] maxCost;
    void dfs(int v, int parent){
        p[v] = parent;
        for (Edge edge : g[v]) {
            if(edge.to == parent)
                continue;
            cost[edge.to] = edge.price;
            d[edge.to] = d[v]+1;
            maxD = Math.max(maxD, d[edge.to]);
            dfs(edge.to, v);
        }
    }
    int jump(int v, int D){
        for (int i = 0; i <= logD; i++) {
            if((D&(1<<i)) > 0){
                v = jump[v][i];
                if(v == -1)
                    return -1;
            }
        }
        return v;
    }
    int lca(int v, int u){
        if(d[v] > d[u]){
            v = jump(v, d[v]-d[u]);
        }
        if(d[u] > d[v]){
            u = jump(u, d[u]-d[v]);
        }
        if(u == v)
            return v;
        for(int i = logD; i >= 0; i--){
            int vv = jump[v][i];
            int uu = jump[u][i];
            if(uu != vv){
                u = uu;
                v = vv;
            }
        }
        if(p[u] != p[v])
            throw new RuntimeException();
        return p[v];
    }
    int max, min;
    int INF = 1_000_000_000;
    void ans(int v, int u) {
        int lca = lca(v,u);
        int D = d[v]-d[lca];
        min = INF;
        max = 0;
        for (int i = 0; i <= logD; i++) {
            if((D&(1<<i)) > 0){
                min = Math.min(min, minCost[v][i]);
                max = Math.max(max, maxCost[v][i]);
                v = jump[v][i];
            }
        }
        D = d[u]-d[lca];
        for (int i = 0; i <= logD; i++) {
            if((D&(1<<i)) > 0){
                min = Math.min(min, minCost[u][i]);
                max = Math.max(max, maxCost[u][i]);
                u = jump[u][i];
            }
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni();
        g = new List[N];
        for (int i = 0; i < N; i++) {
            g[i] = new LinkedList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            int from = in.ni()-1, to = in.ni()-1, cst = in.ni();
            g[from].add(new Edge(from, to, cst));
            g[to].add(new Edge(to, from, cst));
        }
        p = new int[N];
        cost = new int[N];
        d = new int[N];
        dfs(0,-1);
        logD = Integer.numberOfTrailingZeros(Integer.highestOneBit(maxD));
        jump = new int[N][logD+1];
        minCost = new int[N][logD+1];
        maxCost = new int[N][logD+1];
        for (int i = 0; i < N; i++) {
            jump[i][0] = p[i];
            minCost[i][0] = maxCost[i][0] = cost[i];
        }
        for (int log = 1; log <= logD ; log++) {
            for (int i = 0; i < N; i++) {
                if(jump[i][log-1] != -1) {
                    jump[i][log] = jump[jump[i][log - 1]][log - 1];
                    minCost[i][log] = Math.min(minCost[i][log-1], minCost[jump[i][log-1]][log-1]);
                    maxCost[i][log] = Math.max(maxCost[i][log-1], maxCost[jump[i][log-1]][log-1]);
                }
            }
        }
        int K = in.ni();
        for (int k = 0; k < K; k++) {
            int v = in.ni()-1, u = in.ni()-1;
            ans(v,u);
            out.printf("%d %d%n", min, max);
        }
    }
}
