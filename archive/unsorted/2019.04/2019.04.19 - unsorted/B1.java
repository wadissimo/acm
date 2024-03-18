package codeforces.r459;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;

public class B1 {
    class Edge{
        int from, to;
        int c;

        public Edge(int from, int to, int c) {
            this.from = from;
            this.to = to;
            this.c = c;
        }
    }
    LinkedList<Edge>[] g;
    Boolean[][][] dp;
    boolean dfs(int v, int u, int c){
        if(dp[v][u][c] != null){
            return dp[v][u][c];
        }
        boolean win = false;
        for (Edge edge : g[v]) {
            if(edge.c >= c){
                if(!dfs(u,edge.to,edge.c))
                    win = true;
            }
        }
        return dp[v][u][c] = win;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        g = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            int from = in.ni()-1, to = in.ni()-1;
            char c = in.ns().charAt(0);
            g[from].add(new Edge(from, to, c-'a'));
        }
        dp = new Boolean[n][n][26];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dfs(i,j,0);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(dp[i][j][0])
                    out.print('A');
                else
                    out.print('B');
            }
            out.println();
        }
        
        
    }
}
