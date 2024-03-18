package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class TaskG {
    class Edge{
        int id, from, to, type;
        boolean rev;

        public Edge(int id, int from, int to, int type, boolean rev) {
            this.id = id;
            this.from = from;
            this.to = to;
            this.type = type;
            this.rev = rev;
        }
    }
    boolean[] used;
    boolean[] ansMax;
    boolean[] ansMin;
    List<Edge>[] g;
    void dfsMax(int v){
        for (Edge e : g[v]) {
            if(used[e.to])
                continue;
            used[e.to] = true;
            if(e.type == 2){
               ansMax[e.id] = !e.rev;
            }
            dfsMax(e.to);
        }
    }
    void dfsMin(int v){
        for (Edge e : g[v]) {
            if(used[e.to])
                continue;
            if(e.type == 2){
                ansMin[e.id] = e.rev;
            } else {
                used[e.to] = true;
                dfsMin(e.to);
            }
        }
    }


    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni(), M = in.ni(), s = in.ni();
        used = new boolean[N];
        ansMax = new boolean[M];
        ansMin = new boolean[M];
        g = new List[N];
        for (int i = 0; i < N; i++) {
            g[i] = new LinkedList<>();
        }
        Edge[] edges = new Edge[M];
        for (int i = 0; i < M; i++) {
            int type = in.ni(), from = in.ni()-1, to = in.ni()-1;
            Edge e = new Edge(i, from, to, type, false);
            edges[i] = e;
            g[from].add(e);
            if(type == 2)
                g[to].add(new Edge(i, to, from, type, true));
        }
        used[s-1] = true;
        dfsMax(s-1);
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            if(used[i]){
                cnt++;
                used[i] = false;
            }
        }
        out.println(cnt);
        for (int i = 0; i < M; i++) {
            if(edges[i].type != 2)
                continue;
            if(ansMax[i])
                out.print('+');
            else
                out.print('-');
        }
        out.println();
        used[s-1] = true;
        dfsMin(s-1);
        cnt = 0;
        for (int i = 0; i < N; i++) {
            if(used[i])
                cnt++;
        }
        out.println(cnt);
        for (int i = 0; i < M; i++) {
            if(edges[i].type != 2)
                continue;
            if(ansMin[i])
                out.print('+');
            else
                out.print('-');
        }


    }
}
