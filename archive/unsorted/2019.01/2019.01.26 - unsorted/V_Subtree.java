package atcoder.dp;

import chelper.io.FastScanner;
import common.GraphUtil;
import common.GraphUtil.Edge;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class V_Subtree {
    int n;
    int m;
    List<Edge>[] g;
    class Node{
        int id, p;
        List<Node> children;
        long down;
        long up;
        long up1;

        public Node(int id, int p) {
            this.id = id;
            this.p = p;
            children = new LinkedList<>();
        }
    }
    Node[] tree;
    void dfs1(int v){
        tree[v].down = 1;
        for (Edge edge : g[v]) {
            int u = edge.to;
            if(tree[u] == null){
                tree[u] = new Node(u, v);
                tree[v].children.add(tree[u]);
                dfs1(u);
                tree[v].down = tree[v].down*(tree[u].down+1)%m;
            }
        }
    }
    void dfs2(int v){
        if(tree[v].p != -1){
            Node node = tree[v];
            Node parent = tree[node.p];
            node.up = (parent.up+1) * node.up1%m;
        }
        for (Node child : tree[v].children) {
            dfs2(child.id);
        }
    }


    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        n = in.ni();
        m = in.ni();
        g = in.readEdgesGraph(n, n-1, true);
        tree = new Node[n];
        tree[0] = new Node(0, -1);

        dfs1(0);
        for (int i = 0; i < n; i++) {
            Node node = tree[i];
            if(node.children.size() != 0) {
                long[] pref = new long[node.children.size()+1];
                pref[0] = 1;
                int j = 1;
                for (Node child : node.children) {
                    pref[j] = pref[j-1]*(child.down+1)%m;
                    j++;
                }
                ListIterator<Node> li = node.children.listIterator(node.children.size());
                long suf = 1;
                j = node.children.size()-1;
                while(li.hasPrevious()){
                    Node child = li.previous();
                    child.up1 = pref[j]*suf%m;
                    suf = suf*(child.down+1)%m;
                    j--;
                }

            }
        }
        dfs2(0);
        for (int i = 0; i < n; i++) {
            out.println((tree[i].down*(tree[i].up+1))%m);
        }

    }
}
