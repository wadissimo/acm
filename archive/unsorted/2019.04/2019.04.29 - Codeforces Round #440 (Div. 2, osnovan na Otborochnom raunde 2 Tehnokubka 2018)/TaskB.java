package main;

import chelper.io.FastScanner;
import common.ArrayUtils;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.Arrays;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(); int k = in.ni();
        int[] a = in.na(n);
        int min = a[0];
        int max = a[0];
        for (int i = 0; i < n; i++) {
            min = Math.min(a[i], min);
            max = Math.max(a[i], max);
        }
        if(k == 1){
            out.println(min);
            return;
        }
        if(a[0] == max || a[n-1] == max || k >= 3){
            out.println(max);
            return;
        }
        out.println(Math.max(a[0], a[n-1]));
    }
}
