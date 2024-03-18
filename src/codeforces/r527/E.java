package codeforces.r527;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class E {
    class Tree{
        int h, c, diam;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        int[][] g = in.readGraph(n, m);
        boolean[] used = new boolean[n];
        int[] queue = new int[n];
        int qi = 0;
        int[] from = new int[n];
        int[] d = new int[n];
        ArrayList<Tree> trees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if(!used[i]){
                qi = 1;
                used[i] = true;
                queue[0] = i;
                for (int j = 0; j < qi; j++) {
                    int v = queue[j];
                    for (int u : g[v]) {
                        if(!used[u]){
                            used[u] = true;
                            queue[qi++] = u;
                        }
                    }
                }
                boolean [] curUsed = new boolean[n];
                int root = queue[qi-1];
                qi = 1;
                queue[0] = root;
                curUsed[root] = true;
                for (int j = 0; j < qi; j++) {
                    int v = queue[j];
                    for (int u : g[v]) {
                        if(!curUsed[u]){
                            curUsed[u] = true;
                            queue[qi++] = u;
                            d[u] = d[v]+1;
                            from[u] = v;
                        }
                    }
                }
                int end = queue[qi-1];
                int diam = d[end];
                int h = Math.max(diam/2, diam - diam/2);
                int mid = end;
                for (int j = 0; j < h; j++) {
                    mid = from[mid];
                }
                Tree t = new Tree();
                t.c = mid;
                t.h = h;
                t.diam = diam;
                trees.add(t);
            }
        }
        Collections.sort(trees, new Comparator<Tree>() {
            @Override
            public int compare(Tree o1, Tree o2) {
                return -Integer.compare(o1.diam, o2.diam);
            }
        });
        Tree t = trees.get(0);
        int diam = t.diam;
        if(trees.size() > 1){
            diam = Math.max(diam, t.h + trees.get(1).h +1);
        }
        if(trees.size() > 2){
            diam = Math.max(diam, trees.get(1).h + 2 + trees.get(2).h);
        }
        out.println(diam);
        for (int i = 1; i < trees.size(); i++) {
            Tree tt = trees.get(i);
            out.printf("%d %d%n", t.c+1, tt.c+1);
        }

    }
}
