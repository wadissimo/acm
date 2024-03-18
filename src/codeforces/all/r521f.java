package codeforces.all;

import chelper.io.FastScanner;
import common.Fenwick;
import common.SegmentTree;

import java.io.PrintWriter;

public class r521f {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();int k = in.ni();int x = in.ni();
        int[] a = in.na(n);
        long[][] sts = new long[x+1][n*4];
        for (int i = 0; i < k; i++) {
            SegmentTree.updateMax(sts[0], i, a[i]);
        }
        for (int step = 1; step < x; step++) {
            for (int i = 0; i < n; i++) {
                long max = 0;
                if(i>0){
                    max = SegmentTree.max(sts[step-1], Math.max(0, i-k), i-1);
                }
                if(max > 0)
                    SegmentTree.updateMax(sts[step], i, max + a[i]);
            }
        }
        long ans = SegmentTree.max(sts[x-1], Math.max(0, n-k), n-1);
        if(ans == 0)
            out.println(-1);
        else
            out.println(ans);

    }
}
