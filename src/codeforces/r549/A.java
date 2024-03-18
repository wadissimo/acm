package codeforces.r549;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int lastOne = -1;
        int lastZero = -1;
        for (int i = 0; i < n; i++) {
            if(a[i] == 0)
                lastZero = i;
            else
                lastOne = i;
        }

        out.println(Math.min(lastOne, lastZero)+1);
    }
}
