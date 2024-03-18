package atcoder.dp;

import chelper.io.FastScanner;

import java.io.PrintWriter;
import java.util.List;

import static common.GraphUtil.*;

public class G {
    int[] dp;
    boolean[] used;
    List<Edge>[] g;
    void dfs(int v){
        for (Edge e : g[v]) {
            int u = e.to;
            if(!used[u]){
                used[u] = true;
                dfs(u);
            }
            dp[v] = Math.max(dp[v], dp[u] + 1);
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();

        g = in.readEdgesGraph(n, m, false);
        dp = new int[n];
        used = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(!used[i]){
                used[i] = true;
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
