package codeforces.r519;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            sum += a[i];
            max = Math.max(max, a[i]);
        }
        int k = 2*sum/n;
        for (; k*n <= 2*sum ; k++);
        out.println(Math.max(max, k));
    }
}
