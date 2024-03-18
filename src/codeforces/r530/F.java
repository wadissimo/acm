package codeforces.r530;

import chelper.io.FastScanner;
import common.Fenwick;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class F {
    class Node{
        int p, l;
        List<Integer> children = new LinkedList<>();
        long best;
    }
    long[] x;
    long[] t;
    Node[] nodes;
    long T = 0;
    Fenwick treeSum;
    Fenwick treeCnt;
    void dfs(int v, long tt){
        if(tt <= 0)
            return;
        treeSum.add((int)t[v], x[v]*t[v]);
        treeCnt.add((int)t[v], x[v]);
        long best = 0, best2 = 0;
        for (int u : nodes[v].children) {
            dfs(u, tt-nodes[u].l*2);
            if(nodes[u].best > best){
                best2 = best;
                best = nodes[u].best;
            } else {
                best2 = Math.max(best2, nodes[u].best);
            }
        }

        long localBest;
        int left = 0, right = 1_000_003;
        if(treeSum.get(right) <= tt)
            localBest = treeCnt.get(right);
        else {
            while (left < right) {
                int mid = (left + right) / 2;
                long sum = treeSum.get(mid);
                if (sum < tt) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }
            long sum = treeSum.get(left - 1);

            localBest = treeCnt.get(left - 1);
            localBest += (tt - sum) / left;
        }
        if(v != 0)
            nodes[v].best = Math.max(localBest, best2);
        else
            nodes[0].best = Math.max(localBest, best);

        treeSum.add((int)t[v], -x[v]*t[v]);
        treeCnt.add((int)t[v], -x[v]);
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(); T = in.nl();
        x = in.nal(n);
        t = in.nal(n);
        nodes = new Node[n];
        for (int i = 0; i < n; i++) {
            nodes[i] = new Node();
        }
        for (int i = 1; i < n; i++) {
            int p = in.ni()-1, l = in.ni();
            nodes[i].p = p;
            nodes[i].l = l;
            nodes[p].children.add(i);
        }
        treeSum = new Fenwick(1_000_007);
        treeCnt = new Fenwick(1_000_007);
        dfs(0, T);
        out.println(nodes[0].best);
    }
}
