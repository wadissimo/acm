package atcoder.agc32;

import chelper.io.FastScanner;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class C {
    class Edge{
        int from, to, id;
        Edge rev;
        boolean used;
        public Edge(int from, int to, int id) {
            this.from = from;
            this.to = to;
            this.id = id;
        }
    }
    Edge[] parent;
    List<Edge>[] g;
    boolean dfs(int v, int p){
        for (Edge edge : g[v]) {
            if(edge.used || edge. to == p)
                continue;
            if(parent[edge.to] == null){
                parent[edge.to] = edge;
                if(dfs(edge.to, v)){
                    return true;
                }
            } else {
                edge.used = edge.rev.used = true;
                int cur = v;
                while(cur != edge.to){
                    parent[cur].used = parent[cur].rev.used = true;
                    cur = parent[cur].from;
                }
                return true;
            }
        }
        return false;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        parent = new Edge[n];
        Edge[] edges = new Edge[m];
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        int[] degree = new int[n];
        for (int i = 0; i < m; i++) {
            int from = in.ni()-1, to = in.ni()-1;
            Edge e = new Edge(from, to, i);
            edges[i] = e;
            g[from].add(e);
            Edge rev = new Edge(to, from, i);
            e.rev = rev; rev.rev = e;
            g[to].add(rev);
            degree[from]++;
            degree[to]++;
        }
        for (int i = 0; i < n; i++) {
            if(degree[i] %2 != 0){
                out.println("No");
                return;
            }
        }
        Edge empty = new Edge(0, 0, -1);
        parent[0] = empty;
        if(dfs(0,-1)){
            for (int it = 0; it < 2; it++) {
                boolean found = false;
                Arrays.fill(parent, null);
                for (int i = 0; i < m; i++) {
                    if (!edges[i].used) {
                        parent[edges[i].from] = empty;
                        found = dfs(edges[i].from, -1);
                        break;
                    }
                }
                if(!found){
                    out.println("No");
                    return;
                }
            }
            out.println("Yes");
        } else{
            out.println("No");;
        }

    }
}
