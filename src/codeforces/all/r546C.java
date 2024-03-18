package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class r546C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        int[][] from = in.nmi(n, m);
        int[][] to = in.nmi(n, m);
        int nd = n+m-1;
        ArrayList<Integer>[] dFrom = new ArrayList[nd];
        ArrayList<Integer>[] dTo = new ArrayList[nd];
        for (int i = 0; i < nd; i++) {
            dFrom[i] = new ArrayList<>(Math.min(n, m)+7);
            dTo[i] = new ArrayList<>(Math.min(n, m)+7);
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dFrom[i+j].add(from[i][j]);
                dTo[i+j].add(to[i][j]);
            }
        }
        for (int i = 0; i < nd; i++) {
            Collections.sort(dFrom[i]);
            Collections.sort(dTo[i]);
            for (int j = 0; j < dFrom[i].size(); j++) {
                if(!dFrom[i].get(j).equals(dTo[i].get(j))){
                    out.println("NO");
                    return;
                }
            }
        }
        out.println("YES");

    }
}
