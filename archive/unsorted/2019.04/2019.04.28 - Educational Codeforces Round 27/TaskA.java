package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(2*n);
        Arrays.sort(a);
        if(a[n] == a[n-1])
            out.println("NO");
        else out.println("YES");
    }
}
