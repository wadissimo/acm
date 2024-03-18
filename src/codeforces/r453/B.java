package codeforces.r453;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class B {
    class Node{
        int id, p;
        List<Integer> children;

        public Node(int id, int p) {
            this.id = id;
            children = new LinkedList<>();
            this.p = p;
        }
    }
    void dfs(int v, int col){
        if(col != c[v])
            ans++;
        for (int id : nodes[v].children) {
            dfs(id, c[v]);
        }
    }
    int ans = 0;
    Node[] nodes;
    int[] c;
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, -1);
        }
        for (int i = 1; i < n; i++) {
            int p = in.ni()-1;
            nodes[p].children.add(i);
            nodes[i].p = p;
        }
        c = in.na(n);
        dfs(0, -1);
        out.println(ans);
    }
}
