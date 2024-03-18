package codeforces.r549;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeSet;

public class C {
    class Node{
        int v;
        int c;
        int p;
        List<Integer> children;

        public Node(int v) {
            this.v = v;
            children = new LinkedList<>();
        }

    }
    Node[] nodes;
    boolean[] good;

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        good = new boolean[n];
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i);
        }
        for (int i = 0; i < n; i++) {
            int p = in.ni()-1;
            nodes[i].p = p;
            nodes[i].c = in.ni();
            if(p != -2){
                nodes[p].children.add(i);
            }
        }
        TreeSet<Integer> ans = new TreeSet<>();
        for (Node node : nodes) {
            if(node.p != -2 && node.c == 1){
                boolean toDelete = true;
                for (Integer u : node.children) {
                    if(nodes[u].c == 0){
                        toDelete = false;
                        break;
                    }
                }
                if(toDelete)
                    ans.add(node.v+1);
            }
        }
        if(ans.isEmpty()){
            out.println(-1);
            return;
        }
        for (Integer v : ans) {
            out.print(v + " ");
        }
        out.println();

    }
}
