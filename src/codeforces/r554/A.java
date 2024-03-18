package codeforces.r554;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n= in.ni(), m = in.ni();
        int[] a = in.na(n);
        int[] b = in.na(m);
        int aOdd = 0, bOdd = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] %2 == 1)
                aOdd++;
        }
        for (int i = 0; i < m; i++) {
            if(b[i]%2 == 1)
                bOdd++;
        }
        out.println(Math.min(aOdd, m-bOdd)+Math.min(bOdd, n-aOdd));
    }
}
