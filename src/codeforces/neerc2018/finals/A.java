package codeforces.neerc2018.finals;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        long mask = (1L<<32)-1;
        for (int t = 0; t < T; t++) {
            int n = in.ni(); long l = in.nl(), r = in.nl(), x = in.nl(), y = in.nl(), z = in.nl(), b1 = in.nl(), b2 = in.nl();
            long[] b = new long[n];
            b[0] = b1; b[1] = b2;
            for (int i = 2; i < n; i++) {
                long l1 = (b[i - 2] * x) + (b[i - 1] * y) + z;
                b[i] = l1&mask;
            }
            for (int i = 0; i < n; i++) {
                b[i] =b[i]%(r-l+1L) + l;
            }
            long ans = Long.MAX_VALUE;
            long max = Long.MIN_VALUE;
            //System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
            long min = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                if(b[i] >= 0){
                    if(b[i] > min){
                        ans = Math.min(ans, min*b[i]);
                    }
                    min = Math.min(min, b[i]);
                }
            }
            for (int i = n-1; i >= 0 ; i--) {
                if(b[i] < 0) {
                    if(b[i] < max){
                        ans = Math.min(ans, b[i]*max);
                    }
                }
                max = Math.max(max, b[i]);
            }

            if(ans == Long.MAX_VALUE)
                out.println("IMPOSSIBLE");
            else
                out.println(ans);
        }
    }
}
