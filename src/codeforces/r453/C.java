package codeforces.r453;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;
import java.util.Arrays;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n+1);
        int where = -1;
        int tot = a[0];
        for (int i = 1; i < n+1; i++) {
            if(a[i] > 1 && a[i-1] > 1 && where == -1){
                where = i;
            }
            tot+=a[i];
        }
        if(where == -1){
            out.println("perfect");
            return;
        }
        out.println("ambiguous");
        int[]p1 = new int[tot];
        int cur = 1;
        for (int i = 1; i < n + 1; i++) {
            int prev = cur-1;
            for (int j = 0; j < a[i]; j++) {
                p1[cur++] = prev+1;
            }
        }
        cur = 1;
        int[] p2 = new int[tot];
        for (int i = 1; i < n+1; i++) {
            int prev = cur-1;
            for (int j = 0; j < a[i]; j++) {
                p2[cur++] = prev+1;
            }
            if(i == where){
                p2[cur-1] = prev;
            }
        }
        out.println(ArrayUtils.printArray(p1));
        out.println(ArrayUtils.printArray(p2));


    }
}
