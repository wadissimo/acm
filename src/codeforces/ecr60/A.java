package codeforces.ecr60;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i]);
        }
        int len = 0;
        int ans = 0;
        for (int i = 0; i < n+1; i++) {
            if(i <n && a[i] == max)
                len++;
            else{
                ans = Math.max(ans, len);
                len = 0;
            }
        }
        out.println(ans);
    }
}
