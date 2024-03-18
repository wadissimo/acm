package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni(), r = in.ni();
        int[] s = in.na(n);
        Arrays.sort(s);
        int[] b = in.na(m);
        Arrays.sort(b);
        if(s[0] < b[m-1]) {
            int shares = r / s[0];
            int rem = r % s[0];

            out.println(shares * b[m - 1] + rem);
        } else{
            out.println(r);
        }

    }
}
