package codeforces.all;

import chelper.io.FastScanner;
import common.GraphUtil;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class R474E {
    long mod = (int)1e9 +7;
    int[] v;
    List<GraphUtil.Edge>[] g;
    class Node{
        int id, p;
        long no, ne;//odd +, even -
        long so, se;
        List<Integer> children;

        public Node(int id, int p) {
            this.id = id;
            this.p = p;
            children = new LinkedList<>();
        }
    }
    Node[] nodes;
    long ans = 0;
    void dfs(int u){
        Node node = nodes[u];
        node.no++;
        node.so = v[u];
        ans = (ans+v[u]+mod)%mod;
        for(GraphUtil.Edge e: g[u]){
            if(nodes[e.to] == null){
                Node child = nodes[e.to] = new Node(e.to, u);
                dfs(child.id);
                ans += (node.so+node.se)%mod*(child.ne + child.no)%mod;// start left, left part
                ans += (child.so - child.se)%mod*(node.ne-node.no)%mod;// right part

                ans += (child.so+child.se)%mod*(node.ne + node.no)%mod;// start right, right part
                ans += (node.so - node.se)%mod*(child.ne-child.no)%mod;// left part

                node.so = (node.so + child.se)%mod;
                node.se = (node.se + child.so)%mod;
                node.no = (node.no + child.ne)%mod;
                node.ne = (node.ne + child.no)%mod;
                node.se = (node.se - v[u]*child.no%mod + mod)%mod;
                node.so = (node.so + v[u]*child.ne%mod + mod)%mod;
                ans = (ans%mod+mod)%mod;
            }
        }
    }
    boolean[] used;
    long ans2 = 0;
    int dfs1(int u, boolean plus){
        int cnt = 1;
        for(GraphUtil.Edge e: g[u]){
            if(!used[e.to]){
                used[e.to] = true;
                cnt += dfs1(e.to, !plus);
            }
        }
        if(plus)
            ans2 += cnt*v[u];
        else
            ans2 -= cnt*v[u];
        return cnt;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        v = in.na(n);
        g = in.readEdgesGraph(n, n - 1, true);
        nodes = new Node[n];
        nodes[0] = new Node(0, -1);
        dfs(0);
        /*for (int i = 0; i < n; i++) {
            used = new boolean[n];
            used[i] = true;
            dfs1(i, true);
        }
        System.out.println("ans2 = " + ans2);
        */
        out.println((ans%mod + mod)%mod);
    }
}
