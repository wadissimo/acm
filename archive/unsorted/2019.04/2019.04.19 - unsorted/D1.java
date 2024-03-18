package codeforces.r459;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;

public class D1 {
    class Edge{
        int from, to;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    LinkedList<Edge>[] g;
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        g = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        
        for (int i = 0; i < n - 1; i++) {
            int from = in.ni()-1, to = in.ni()-1;
            g[from].add(new Edge(from, to));
            g[to].add(new Edge(to, from));
        }


    }
}
