package main;

import chelper.io.FastScanner;
import common.DSUSize;

import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni(), M = in.ni();
        DSUSize dsu = new DSUSize(N);
        for (int i = 0; i < M; i++) {
            int k = in.ni();
            if(k == 0)
                continue;
            int first = in.ni()-1;
            if(k == 1)
                continue;
            for (int j = 0; j < k - 1; j++) {
                dsu.union(first, in.ni()-1);
            }
        }
        for (int i = 0; i < N; i++) {
            out.print(dsu.size[dsu.find(i)] + " ");
        }
    }
}
