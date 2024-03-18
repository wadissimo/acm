package codeforces.all;

import chelper.io.FastScanner;
import common.GraphUtil;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class r546_D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        int[] p = in.na(n);
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        boolean[] canJumpOver = new boolean[n];
        int last = p[n-1]-1;
        for (int i = 0; i < m; i++) {
            int u = in.ni()-1, v = in.ni()-1;
            g[u].add(v);
            if(v == last)
                canJumpOver[u] = true;
        }

        boolean[] blockers = new boolean[n];
        int nBlockers = 0;
        int ans = 0;
        for (int i = n-2; i >= 0 ; i--) {
            int no = p[i]-1;
            if(!canJumpOver[no]){
                blockers[no] = true;
                nBlockers ++;
            } else {
                int swaps = 0;
                for (int v : g[no]) {
                    if(blockers[v]){
                        swaps++;
                    }
                }
                if(swaps == nBlockers){
                    ans++;
                } else {
                    blockers[no] = true;
                    nBlockers ++;
                }
            }
        }
        out.println(ans);
    }
}
