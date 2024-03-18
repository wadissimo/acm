package main;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;
import java.util.Arrays;

public class BMahmoudAndATriangle {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        ArrayUtils.randomShuffle(a);
        Arrays.sort(a);
        for (int i = 2; i < n; i++) {
            if(a[i-1]+a[i-2] > a[i]){
                out.println("YES");
                return;
            }
        }
        out.println("NO");
    }
}
