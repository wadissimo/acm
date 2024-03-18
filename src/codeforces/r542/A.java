package codeforces.r542;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int pos = 0;
        int neg = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] > 0)
                pos++;
            else if(a[i]< 0)
                neg++;
        }
        if(pos >= (n+1)/2)
            out.println(1);
        else if(neg >=(n+1)/2)
            out.println(-1);
        else
            out.println(0);
    }
}
