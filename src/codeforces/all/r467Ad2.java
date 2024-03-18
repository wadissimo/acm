package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class r467Ad2 {
    class Edge{
        int from, to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    class Vertex{
        int v;
        int d;
        int reach;
        int from;
        int fromRev;

        public Vertex(int v) {
            this.v = v;
            fromRev = from = reach = -1;
        }
    }
    Vertex[] vs;
    List<Edge> [] g;
    boolean[] used;
    boolean[] closed;
    boolean cyclic;
    void dfs(int v, int dist){
        vs[v].d = dist;
        used[v] = true;
        if(g[v].size() == 0){
            vs[v].reach = v;
        }
        for(Edge e: g[v]){
            if(used[e.to]){
                if(!closed[e.to])
                    cyclic = true;
                if(Math.abs(vs[e.to].d - dist-1) %2 != 0){
                    vs[e.to].fromRev = v;
                }
            } else {
                dfs(e.to, dist +1);
                vs[e.to].from = v;
            }
            if(vs[e.to].reach != -1 && (vs[v].reach == -1 || vs[vs[e.to].reach].d %2 == 1)){
                vs[v].reach = vs[e.to].reach;
            }
        }
        closed[v] = true;
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m =in.ni();
        g = new List[n];
        vs = new Vertex[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
            vs[i] = new Vertex(i);
            int c = in.ni();
            for (int j = 0; j < c; j++) {
                g[i].add(new Edge(i, in.ni() - 1));
            }
        }
        int s = in.ni()-1;
        used = new boolean[n];
        closed = new boolean[n];
        dfs(s, 0);
        boolean win = false;
        int from = -1;
        boolean rev = false;
        for (int i = 0; i < n; i++) {
            if(g[i].size() == 0 && vs[i].d%2 == 1){
                win = true;
                from = i;
                break;
            }
        }
        if(!win){
            for (int i = 0; i < n; i++) {
                if(vs[i].fromRev != -1 && vs[i].reach != -1){
                    from = vs[i].reach;
                    win = true;
                    rev = true;
                    break;
                }
            }
        }
        if(win) {
            out.println("Win");
            LinkedList<Integer> ans = new LinkedList<>();
            while(from != -1){
                ans.push(from+1);
                if(rev && vs[from].fromRev != -1){
                    rev = false;
                    from = vs[from].fromRev;
                } else {
                    from = vs[from].from;
                }
            }
            for(int v: ans){
                out.print(v + " ");
            }
            out.println();
        }else if(cyclic)
            out.println("Draw");
        else out.println("Lose");


    }
}

