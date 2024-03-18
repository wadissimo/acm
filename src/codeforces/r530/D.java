package codeforces.r530;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class D {
    class Node{
        int v, p;
        List<Integer> children;
        int a;

        public Node(int v, int p) {
            this.v = v;
            this.p = p;
            children = new LinkedList<>();
        }
    }
    Node[] nodes;
    int[] s;
    int[] a;
    boolean possible = true;
    void dfs(int v, int sum){
        int min = Integer.MAX_VALUE;
        if(s[v] != -1){
            if(s[v] < sum){
                possible = false;
            }
            sum = s[v];
        }
        for (int u : nodes[v].children) {
            dfs(u, sum);
            if(s[v] == -1)
                min = Math.min(s[u], min);
        }
        if(s[v] == -1){
            if(min == Integer.MAX_VALUE)
                a[v] = 0;
            else {

                a[v] = min - sum;
                for (int u : nodes[v].children) {
                    a[u] = s[u] - sum - a[v];
                }
            }
        }

    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node(i, -1);
        }
        for (int i = 1; i < n; i++) {
            int p = in.ni()-1;
            nodes[i].p = p;
            nodes[p].children.add(i);

        }
        s = in.na(n);
        a = new int[n];
        a[0] = s[0];
        dfs(0, s[0]);
        if(possible) {
            long ans = 0;
            for (int i = 0; i < n; i++) {
                ans += a[i];
            }
            out.println(ans);
        } else {
            out.println(-1);
        }

    }
}
