package codeforces.r446;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int[] sorted = new int[n];
        for (int i = 0; i < n; i++) {
            sorted[i] = a[i];
        }
        Arrays.sort(sorted);
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(sorted[j] == a[i]){
                    if(j == n-1)
                        b[i] = sorted[0];
                    else
                        b[i] = sorted[j+1];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(b[i] + " ");
        }
    }
}
