package codeforces.r455;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class E {
    int[] type;
    int[] dp;
    List<Edge>[] g;
    class Edge{
        int from, to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    void dfs(int v){
        if(g[v].isEmpty()){
            if(type[v] == 1){
                dp[v] = 1;
            } else {
                dp[v] = 0;
            }
            return;
        }
        int max = 0;
        for (Edge edge : g[v]) {
            if(dp[edge.to] == -1){
                dfs(edge.to);
            }
            if(type[edge.to] == 0 && type[v] == 1){
                max = Math.max(max, dp[edge.to]+1);
            } else {
                max = Math.max(max, dp[edge.to]);
            }
        }
        dp[v] = max;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        type = in.na(n);

        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            int from = in.ni(); int to = in.ni();
            g[from].add(new Edge(from, to));
        }
        dp = new int[n];
        Arrays.fill(dp, -1);
        for (int i = 0; i < n; i++) {
            if(dp[i] == -1){
                dfs(i);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, dp[i]);
        }
        out.println(ans);

    }
}
