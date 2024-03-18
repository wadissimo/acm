package codeforces.r547;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] q = in.na(n-1);
        int[] p = new int[n];
        int min = 1;
        p[0] = 1;
        for (int i = 0; i < n - 1; i++) {
            p[i+1] = p[i]+q[i];
            min = Math.min(min, p[i+1]);
        }
        int delta = 1-min;
        boolean[] used = new boolean[n+1];
        boolean correct = true;
        for (int i = 0; i < n; i++) {
            p[i] += delta;
            if(p[i] <1 || p[i] > n || used[p[i]]){
                correct = false;
                break;
            }
            used[p[i]] = true;
        }
        if(correct)
            out.println(ArrayUtils.printArray(p));
        else
            out.println(-1);
    }
}
