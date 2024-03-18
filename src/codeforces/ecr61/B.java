package codeforces.ecr61;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;
import java.util.Arrays;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int m = in.ni();
        int[] q = in.na(m);
        ArrayUtils.randomShuffle(a);
        Arrays.sort(a);
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=a[i];
        }
        for (int i = 0; i < m; i++) {
            out.println(sum-a[n-q[i]]);
        }

    }
}
