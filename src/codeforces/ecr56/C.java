package codeforces.ecr56;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        long[] b = in.nal(n/2);
        long []a = new long[n];
        a[n-1] = b[0];
        for (int i = 1; i < n/2; i++) {
            if(b[i]-a[i-1] <= a[n-i]){
                a[i] = a[i-1];
                a[n-i-1] = b[i]-a[i-1];
            } else{
                a[n-i-1] = a[n-i];
                a[i] = b[i]-a[n-i];
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(a[i] + " ");
        }
        out.println();
    }
}
