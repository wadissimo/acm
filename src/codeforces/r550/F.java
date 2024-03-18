package codeforces.r550;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class F {
    class Edge{
        int from, to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    int[] type;
    boolean[] used;
    List<Edge>[] g;
    void dfs(int v, int typeFrom){
        if(typeFrom == 1)
            type[v] = -1;
        else
            type[v] = 1;
        for (Edge edge : g[v]) {
            if(!used[edge.to]){
                used[edge.to] = true;

                dfs(edge.to, type[v]);
            }
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();

        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        Edge[] edges = new Edge[m];
        for (int i = 0; i < m; i++) {
            int from = in.ni()-1, to = in.ni()-1;
            Edge e = new Edge(from, to);
            edges[i] = e;
            g[from].add(e);
            g[to].add(new Edge(to, from));
        }
        type = new int[n];
        used = new boolean[n];
        used[0] = true;
        type[0] = 1;
        dfs(0, -1);

        for (Edge edge : edges) {
            if(type[edge.from] == type[edge.to]){
                out.println("NO");
                return;
            }
        }
        out.println("YES");
        for (Edge edge : edges) {
            if(type[edge.from] == 1)
                out.print('1');
            else
                out.print('0');
        }
        out.println();


    }
}
