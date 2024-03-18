package codeforces.r484;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class TaskC {
    class Edge{
        int from, to;
        int cnt;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    List<Edge>[] g;
    int ans = 0;
    int dfs(Edge e){
        int cnt = 1;
        for (Edge edge : g[e.to]) {
            if(edge.to != e.from)
                cnt += dfs(edge);
        }
        if (cnt % 2 == 0)
            ans++;
        return cnt;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int from = in.ni()-1, to = in.ni()-1;
            g[from].add(new Edge(from, to));
            g[to].add(new Edge(to, from));
        }
        if(n%2 != 0){
            out.println(-1);
            return;
        }
        for (Edge edge : g[0]) {
            dfs(edge);
        }

        out.println(ans);
    }
}
