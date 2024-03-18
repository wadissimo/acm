package codeforces.r554;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.*;

public class E {
    class Edge{
        int from, to;
        Edge rev;
        boolean used;

        public Edge(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    int[] remap;
    int size;
    TreeMap<Integer, Integer> map;
    LinkedList<Edge>[] g;
    LinkedList<Integer> ans;
    void dfs(int v){
        while(!g[v].isEmpty()){
            Edge e = g[v].pop();
            if(e.used)
                continue;
            e.used = e.rev.used = true;
            dfs(e.to);
        }
        ans.add(remap[v]);
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] b = in.na(n-1);
        int[] c = in.na(n-1);

        map = new TreeMap<>();
        boolean invalid = false;
        for (int i = 0; i < n-1; i++) {
            map.put(b[i], map.getOrDefault(b[i], 0)+1);
            map.put(c[i], map.getOrDefault(c[i], 0)+1);
            if(b[i] > c[i])
                invalid = true;
        }
        if(invalid){
            out.println(-1);
            return;
        }
        int start = -1, end = -1;
        int idx = 0;
        remap = new int[n];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            remap[idx] = entry.getKey();
            if(entry.getValue()%2 == 1){
                if(start == -1){
                    start = idx;
                } else if(end == -1){
                    end = idx;
                } else {
                    out.println(-1);
                    return;
                }
            }
            entry.setValue(idx++);
        }
        if(start == -1)
            start = end = 0;

        size = idx;

        g = new LinkedList[size];
        for (int i = 0; i < size; i++) {
            g[i] = new LinkedList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            Integer bb = map.get(b[i]);
            Integer cc = map.get(c[i]);
            Edge edge = new Edge(bb, cc);
            Edge rev = new Edge(cc, bb);
            edge.rev = rev; rev.rev = edge;
            g[bb].add(edge);
            g[cc].add(rev);
        }
        ans = new LinkedList<>();
        dfs(start);
        if(ans.size() != n){
            out.println(-1);
            return;
        } else {
            for (Integer num : ans) {
                out.print(num + " ");
            }
        }

    }
}
