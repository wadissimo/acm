package codeforces.r547;

import chelper.io.FastScanner;
import common.GraphUtil;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class G {
    class Edge{
        int id;
        int from, to, c;

        public Edge(int id, int from, int to) {
            this.id = id;
            this.from = from;
            this.to = to;
        }
    }
    List<Edge>[] g;

    int[] degree;
    boolean[] used;
    boolean[] bad;
    int[] cs;
    void dfs(int v, Edge from){
        int parentColor = 0;
        if(from != null)
            parentColor = cs[from.id];
        if(bad[v]){
            for (Edge edge : g[v]) {
                cs[edge.id] = parentColor;
            }
        } else {
            int color = 0;
            for (Edge edge : g[v]) {
                if(from != null && edge.id == from.id)
                    continue;
                if(color == parentColor && from != null) color++;
                cs[edge.id] = color++;
            }
        }
        for (Edge edge : g[v]) {
            if(from != null && edge.id == from.id)
                continue;
            dfs(edge.to, edge);
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        g = new List[n];
        degree = new int[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int a = in.ni()-1, b = in.ni()-1;
            g[a].add(new Edge(i,a,b));
            g[b].add(new Edge(i,b,a));
            degree[a]++;degree[b]++;
        }

        Integer[] idx = new Integer[n];
        for (int i = 0; i < n; i++) {
            idx[i] = i;
        }
        Arrays.sort(idx, (a,b)->(-Integer.compare(degree[a], degree[b])));
        bad = new boolean[n];
        for (int i = 0; i < k; i++) {
            bad[idx[i]] = true;
        }
        int ans = 0;
        for (int i = k; i < n; i++) {
            ans = Math.max(degree[idx[i]], ans);
        }
        used = new boolean[n];
        cs = new int[n-1];
        dfs(0, null);
        out.println(ans);
        for (int i = 0; i < n - 1; i++) {
            out.print((cs[i]+1) + " ");
        }
    }
}
