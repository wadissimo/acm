package codeforces.r519;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        int n = s.length();
        int[]a = new int[n];
        int[]b = new int[n];// "a" = 1, b = 0
        int bi = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == 'a'){
                a[i] = 1;
                b[bi++] = 1;
            }
        }
        int[] ans = new int[n];
        for (int i = n-1; i >= 0 ; i--) {
            if(a[i] != b[i]){
                ans[i] = 1;
                for (int j = 0; j < (i + 1) / 2; j++) {
                    int t = b[j];
                    b[j] = b[i-j];
                    b[i-j] = t;
                }
            }
        }
        //System.out.println(ArrayUtils.printArray(a));
        //System.out.println(ArrayUtils.printArray(b));
        out.println(ArrayUtils.printArray(ans));
    }
}
