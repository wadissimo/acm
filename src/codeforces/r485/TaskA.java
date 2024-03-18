package codeforces.r485;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int m = in.ni();
        int k = in.ni();
        int s = in.ni();
        int a[] = in.na(n);
        int[][] g = in.readGraph(n,m);
        int[][] qs = new int[k][n];
        int[] qn = new int[k];
        for (int i = 0; i < n; i++) {
            int ak = --a[i];
            qs[ak][qn[ak]++] = i;
        }
        int[][] dp = new int[n][k];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
            dp[i][a[i]] = 0;
        }

        for (int i = 0; i < k; i++) {
            boolean[] visited = new boolean[n];
            int[] queue = qs[i];
            int qend = qn[i];
            for (int j = 0; j < qend; j++) {
                visited[queue[j]] = true;
            }
            for (int j = 0; j < qend; j++) {
                int v = queue[j];
                for (int u : g[v]) {
                    if (!visited[u]) {
                        dp[u][i] = Math.min(dp[v][i] + 1, dp[u][i]);
                        queue[qend++] = u;
                        visited[u] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            Arrays.sort(dp[i]);
            int sum = 0;
            for (int j = 0; j < s; j++) {
                sum += dp[i][j];
            }
            sb.append(sum);
            sb.append(' ');
        }
        out.println(sb.toString());
    }
}
