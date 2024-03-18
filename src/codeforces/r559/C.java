package codeforces.r559;

import chelper.io.FastScanner;
import common.ArrayUtils;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.PriorityQueue;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni(), M = in.ni();
        int[] b = in.na(N); int[] g = in.na(M);
        ArrayUtils.randomShuffle(b);
        ArrayUtils.randomShuffle(g);
        Arrays.sort(b);
        Arrays.sort(g);
        if(g[0] < b[N-1]){
            out.println(-1);
            return;
        }
        long ans = 0;
        for (int i = 0; i < M; i++) {
            ans += g[i];
        }
        for (int i = 0; i < N - 1; i++) {
            ans += (long)b[i]*M;
        }
        if(g[0] > b[N-1]){
            ans += b[N-1] -b[N-2];
        }
        out.println(ans);
    }
}
