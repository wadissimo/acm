package codeforces.r551;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class D {
    class Node{
        int id;
        List<Node> children;

        public Node(int id) {
            this.id = id;
            children = new LinkedList<>();
        }
    }
    int n;
    int[] flag;
    Node[] nodes;
    int dfs(Node v){
        if(v.children.isEmpty()){
            return 1;
        }
        if(flag[v.id] == 1){
            int best = n;
            for (Node child : v.children) {
                best = Math.min(best, dfs(child));
            }
            return best;
        } else {
            int sum = 0;
            for (Node child : v.children) {
                sum+=dfs(child);
            }
            return sum;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        n = in.ni();
        flag = in.na(n);
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 1; i < n; i++) {
            int p = in.ni()-1;
            nodes[p].children.add(nodes[i]);
        }
        int k = 0;
        for (int i = 0; i < n; i++) {
            if(nodes[i].children.isEmpty())
                k++;
        }
        out.println(k-dfs(nodes[0])+1);
    }
}
