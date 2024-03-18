package codeforces.r541;

import chelper.io.FastScanner;
import common.DSU;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class D {
    class Edge{
        int from, to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    List<Edge>[] g;
    boolean[] used;
    boolean[] processed;
    int[] val;

    private boolean dfs(int v){
        used[v] = true;
        int min = 10000;
        for (Edge e : g[v]) {
            if(!used[e.to]){
                if(!dfs(e.to))
                    return false;
            } else if(!processed[e.to]){
                return false;
            }
            min = Math.min(min, val[e.to]);
        }
        val[v] = min-1;
        processed[v] = true;
        return true;
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        char[][] map = in.nm(n,m);
        DSU dsu = new DSU(n+m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == '='){
                    dsu.union(i, n+j);
                }
            }
        }

        g = new List[n+m];
        for (int i = 0; i < n + m; i++) {
            g[i] = new LinkedList<>();
        }
        int[] dIn = new int[n+m];
        int[] dOut = new int[n+m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == '<'){
                    int from = dsu.find(i);
                    int to = dsu.find(n+j);
                    g[from].add(new Edge(from, to));
                    dOut[from]++;
                    dIn[to]++;
                } else if(map[i][j] == '>'){
                    int from = dsu.find(n+j);
                    int to = dsu.find(i);
                    g[from].add(new Edge(from, to));
                    dOut[from]++;
                    dIn[to]++;
                }
            }
        }

        used = new boolean[n+m];
        processed = new boolean[n+m];
        val = new int[n+m];
        while(true){
            int start = -1;
            for (int i = 0; i < n + m; i++) {
                if(!processed[i] && dIn[i] == 0 && dOut[i] > 0){
                    start = i;
                    break;
                }
            }
            if(start == -1){
                break;
            }
            if(!dfs(start)){
                out.println("No");
                return;
            }
        }
        for (int i = 0; i < n + m; i++) {
            if(!processed[i] && dOut[i] > 0){
                out.println("No");
                return;
            }
        }
        int min = 10000;
        for (int i = 0; i < n + m; i++) {
            if(val[i] != 0){
                min = Math.min(val[i], min);
            }
        }
        if(min == 10000)
            min = 0;
        min--;
        out.println("Yes");
        for (int i = 0; i < n; i++) {
            out.printf("%d ", val[dsu.find(i)]-min);
        }
        out.println();
        for (int i = 0; i < m; i++) {
            out.printf("%d ", val[dsu.find(n+i)]-min);
        }






    }
}
