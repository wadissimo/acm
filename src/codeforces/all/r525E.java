package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.Stack;

public class r525E {
    class Node{
        int p;
        int id;
        long best;
        LinkedList<Integer> children = new LinkedList<>();
        public Node(int p, int id) {
            this.p = p;
            this.id = id;
        }
        public void add(int v){
            children.add(v);
        }

    }
    Node[] nodes;
    int[]a;
    int n;
    long bestOfbest = Integer.MIN_VALUE;

    void dfs(int v){
        Node node = nodes[v];
        node.best = a[v];
        long sum = 0;
        for (int u : node.children) {
            dfs(u);
            if(nodes[u].best > 0){
                sum += nodes[u].best;
            }
        }
        node.best += sum;
        bestOfbest = Math.max(bestOfbest, node.best);
    }
    int k = 0;
    void dfs2(int v){
        Node node = nodes[v];
        long sum = 0;
        for (int u : node.children) {
            dfs2(u);
            if(nodes[u].best > 0){
                sum += nodes[u].best;
            }
        }
        if(a[v] + sum == bestOfbest){
            k++;
            node.best = Integer.MIN_VALUE;
        } else {
            node.best = a[v] + sum;
        }

    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        n = in.ni();
        a = in.na(n);
        LinkedList<Integer>[] g = new LinkedList[n];

        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
            nodes[i] = new Node(i,-1);
        }

        for (int i = 0; i < n - 1; i++) {
            int u = in.ni()-1;
            int v = in.ni()-1;
            g[u].add(v);
            g[v].add(u);
        }
        Stack<Integer> st = new Stack<>();
        boolean[] used = new boolean[n];
        st.add(0);
        used[0] = true;
        while(!st.isEmpty()){
            int v = st.pop();
            for (int u : g[v]) {
                if(!used[u]){
                    nodes[u].p = v;
                    nodes[v].add(u);
                    st.push(u);
                    used[u] = true;
                }
            }
        }
        dfs(0);
        dfs2(0);
        out.println(bestOfbest*k + " " + k);
    }
}
