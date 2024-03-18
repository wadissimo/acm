package codeforces.avito2018;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class C {
    class Edge{
        int from, to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        List<Edge> g [] = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int from = in.ni()-1, to = in.ni()-1;
            g[from].add(new Edge(from, to));
            g[to].add(new Edge(to, from));
        }
        int cnt = 0;
        int root = -1;
        for (int i = 0; i < n; i++) {
            if(g[i].size() > 2){
                cnt++;
                root = i;
            } else
            if(root == -1 && g[i].size() == 1)
                root = i;
        }
        if(cnt > 1)
            out.println("No");
        else{
            out.println("Yes");
            out.println(g[root].size());
            for (Edge edge : g[root]) {
                int from = root;
                int v = edge.to;
                while(v != -1){
                    int next = -1;
                    for (Edge e : g[v]) {
                        if(e.to != from){
                            next = e.to;
                        }
                    }
                    from = v;
                    v = next;
                }
                out.println((root+1) + " " + (from +1));
            }
        }
    }
}
