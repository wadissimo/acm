package atcoder.agc32;

import chelper.io.FastScanner;
import common.GraphUtil;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class C1 {
    class Edge{
        int from, to, id;

        public Edge(int from, int to, int id) {
            this.from = from;
            this.to = to;
            this.id = id;
        }
    }
    List<Edge>[] g;
    boolean[] used;

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();

        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        int[] degree = new int[n];
        for (int i = 0; i < m; i++) {
            int from = in.ni()-1, to = in.ni()-1;
            g[from].add(new Edge(from, to, i));
            g[to].add(new Edge(to, from, i));
            degree[from]++;degree[to]++;
        }
        LinkedList<Integer> degree4 = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (degree[i] % 2 == 1) {
                out.println("No");
                return;
            }
        }
        for (int i = 0; i < n; i++) {
            if(degree[i] >= 6){
                out.println("Yes");
                return;
            }
            if(degree[i] == 4){
                degree4.add(i);
            }
        }
        if(degree4.size() > 2){
            out.println("Yes");
            return;
        }
        if(degree4.size() < 2){
            out.println("No");
            return;
        }
        int from = degree4.getFirst();
        int to = degree4.getLast();
        boolean circle = false;
        for (Edge edge : g[from]) {
            int prev = from;
            int cur = edge.to;
//            System.out.println("edge.to = " + edge.to);
            while(cur != from && cur != to){
                for (Edge e : g[cur]) {
                    if(e.to != prev){
                        prev = cur;
                        cur = e.to;
                        break;
                    }
                }
            }
//            System.out.println("cur = " + cur);
            if(cur == from){
                circle = true;
                break;
            }
        }
        if(circle){
            out.println("Yes");
        } else
            out.println("No");




    }
}
