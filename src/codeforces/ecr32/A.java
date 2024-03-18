package codeforces.ecr32;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int cnt = 0;
        for (int i = 1; i < n - 1; i++) {
            if (a[i] > a[i - 1] && a[i] > a[i + 1] || a[i] < a[i-1] && a[i] < a[i+1]) {
                cnt++;
            }
        }
        out.println(cnt);
    }
}
