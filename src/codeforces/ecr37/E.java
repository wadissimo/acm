package codeforces.ecr37;

import chelper.io.FastScanner;
import common.GraphUtil;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

public class E {
    int n;
    List<GraphUtil.Edge>[] g;

    int[] size, parent;
    int sets;

    public int find(int x) {
        if (parent[x]!=x) {
            parent[x] = find(parent[x]);
        }
        return parent[x];
    }

    public void union(int x, int y) {
        int xRoot = find(x), yRoot = find(y);
        if (xRoot == yRoot)
            return;
        sets--;
        int newSize = size[xRoot] + size[yRoot];
        if (size[xRoot] < size[yRoot]) {
            parent[xRoot] = yRoot;
            size[yRoot] = newSize;
            size[xRoot] = 0;
        }else {
            parent[yRoot] = xRoot;
            size[xRoot] = newSize;
            size[yRoot] = 0;
        }
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {

        n = in.ni();
        int m = in.ni();

        g = in.readEdgesGraph(n, m, true);
        sets = n;
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int min = Integer.MAX_VALUE;
        int start = 0;
        for (int i = 0; i < n; i++) {
            if(g[i].size() < min){
                min = g[i].size();
                start = i;
            }
        }
        boolean[] disj = new boolean[n];
        for(GraphUtil.Edge e: g[start]){
            disj[e.to] = true;
        }
        for (int i = 0; i < n; i++) {
            if(i != start && !disj[i]){
                union(start, i);
            }
        }
        for (int i = 0; i < n; i++) {
            if(i!=start && disj[i]){
                boolean[] curDisj = new boolean[n];
                for(GraphUtil.Edge e: g[i]){
                    curDisj[e.to] = true;
                }
                for (int j = 0; j < n; j++) {
                    if(j != i && !curDisj[j]){
                        union(i, j);
                    }
                }
            }
        }
        out.println(sets);
        Arrays.sort(size);
        for (int i = 0; i < n; i++) {
            if(size[i] != 0){
                out.print(size[i] + " ");
            }
        }

    }
}
