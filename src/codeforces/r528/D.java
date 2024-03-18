package codeforces.r528;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class D {
    int[][] g;
    boolean[] used;
    int ends = 0;
    void dfs(int v){
        boolean end = true;
        for (int u : g[v]) {
            if(!used[u]){
                used[u] =true;
                end = false;
                dfs(u);
            }
        }
        if(end)
            ends++;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), s = in.ni();
        g = in.readGraph(n, n - 1);
        if(n==2){
            out.println(s);
            return;
        }
        used = new boolean[n];
        for (int i = 0; i < n; i++) {
            if(g[i].length > 1){
                used[i] = true;
                dfs(i);
                break;
            }
        }

        double x = ((double)s)/ends;
        out.println(x*2);
    }
}
