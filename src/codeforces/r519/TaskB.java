package codeforces.r519;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;
import java.util.LinkedList;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int prev = 0;
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            b[i] = a[i]-prev;
            prev = a[i];
        }
        LinkedList<Integer> ans = new LinkedList<>();
        for (int i = n; i > 0 ; i--) {
            boolean correct = true;
            for (int j = 0; j < n-i; j++) {
                if(b[j] != b[i+j]){
                    correct = false;
                    break;
                }
            }
            if(correct){
                ans.addFirst(i);
            }
        }
        out.println(ans.size());
        for (Integer x : ans) {
            out.print(x+" ");
        }
        out.println();
    }
}
