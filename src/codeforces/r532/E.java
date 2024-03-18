package codeforces.r532;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class E {
    class Edge{
        int id;
        int from, to;
        int c;
        boolean reverse;

        public Edge(int id, int from, int to, int c) {
            this.id = id;
            this.from = from;
            this.to = to;
            this.c = c;
        }
    }
    LinkedList<Edge>[] g;
    boolean checkCyclic(int k){//ignore <= k edges
        int n = g.length;
        int[] mark = new int[n];
        Arrays.fill(mark, -1);
        Stack<Integer> st = new Stack<>();
        for (int root = 0; root < n; root++) {
            if(mark[root] != -1)
                continue;
            st.push(root);
            mark[root] = root;
            while (!st.isEmpty()) {
                int v = st.pop();
                for (Edge edge : g[v]) {
                    if (edge.c <= k)
                        continue;
                    if (mark[edge.to] == -1) {
                        mark[edge.to] = root;
                        st.push(edge.to);
                    } else if(mark[edge.to] == root){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        Edge[] edges = new Edge[m];
        g = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        for (int i = 0; i < m; i++) {
            int from = in.ni()-1;
            edges[i] = new Edge(i, from, in.ni()-1, in.ni());
            g[from].add(edges[i]);
        }
        int left = 0;
        int right = 1_000_000_000;
        while(left < right){
            int mid = (left+right)/2;
            if(checkCyclic(mid)){
                left = mid+1;
            } else {
                right = mid;
            }
        }
        int k = left;
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] mark = new int[n];
        Arrays.fill(mark, -1);
        int[] time = new int[n];
        int timer = 0;
        for (int root = 0; root < n; root++) {
            if (mark[root] != -1)
                continue;
            mark[root] = root;
            time[root] = ++timer;
            while (!st.isEmpty()) {
                int v = st.pop();
                for (Edge edge : g[v]) {
                    if (edge.c > k && mark[edge.to] == -1) {
                        mark[edge.to] = root;
                        time[edge.to] = ++timer;
                        st.push(edge.to);
                    }
                }
            }
        }
        List<Integer> ans = new LinkedList<>();
        for (Edge edge : edges) {
            if(edge.c <= k){
                if(mark[edge.from] < mark[edge.to] || mark[edge.from]==mark[edge.to] && time[edge.to] < time[edge.from]){
                    ans.add(edge.id);
                }
            }
        }

        out.println(k + " " + ans.size());
        for (int  id : ans) {
            out.print((id+1) + " ");
        }
        out.println();
    }
}
