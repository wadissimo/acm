package codeforces.r446;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int[] b = in.na(n);
        int max = 0;
        int secondMax = 0;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum+= a[i];
            if(b[i] > max){
                secondMax = max;
                max = b[i];
            } else
                secondMax = Math.max(secondMax, b[i]);
        }
        if(max + secondMax >= sum)
            out.println("YES");
        else
            out.println("NO");
    }
}
