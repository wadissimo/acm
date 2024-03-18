package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class TaskD {
    class Edge{
        int from, to, c;

        public Edge(int from, int to, int c) {
            this.from = from;
            this.to = to;
            this.c = c;
        }
    }
    List<Edge>[] g;
    long[] r0, r1, r01, r10;
    long ans = 0;
    void dfs(int v, int p){
//        long prev0 = 0;
//        long prev1 = 0;
//        long prev01 = 0;
//        long prev10 = 0;
        for (Edge edge : g[v]) {
            if(edge.to != p){
                dfs(edge.to, v);
                if(edge.c == 0){
                    ans+= (1+r0[edge.to])*(2*r0[v]+r01[v]) + (r01[edge.to]+r1[edge.to])*r0[v];
                    ans+= (1+r0[edge.to])*r1[v];
                    r0[v] += 1+r0[edge.to];
                    r01[v] += r01[edge.to]+r1[edge.to];

//                    prev0 += r0[edge.to];
//                    prev01 += r01[edge.to]+r1[edge.to];
                } else {
                    ans+= (1+r1[edge.to])*(2*r1[v]+r10[v]) + (r10[edge.to]+r0[edge.to])*r1[v];
                    ans+= (1+r1[edge.to])*r0[v];
                    r1[v] += 1+r1[edge.to];
                    r10[v] += r10[edge.to]+r0[edge.to];

//                    prev1 += r1[edge.to];
//                    prev10 += r10[edge.to]+r0[edge.to];
                }
            }
        }
        ans += 2*r0[v] + 2*r1[v] + r01[v] + r10[v];
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni();
        g = new List[N];
        r0 = new long[N];
        r1 = new long[N];
        r01 = new long[N];
        r10 = new long[N];
        for (int i = 0; i < N; i++) {
            g[i] = new LinkedList<>();
        }
        for (int i = 0; i < N - 1; i++) {
            int from = in.ni()-1, to = in.ni()-1, c = in.ni();
            g[from].add(new Edge(from, to, c));
            g[to].add(new Edge(to, from, c));
        }
        dfs(0,-1);
        out.println(ans);
    }
}
