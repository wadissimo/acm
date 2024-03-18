package codeforces.ecr63;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        long first = in.nl();
        long second = in.nl();
        long gcd = second-first;
        long cur = second;
        for (int i = 0; i < n - 2; i++) {
            long l = in.nl();
            gcd = IntegerUtils.gcd(gcd, l-cur);
            cur = l;
        }
        for (int i = 0; i < m; i++) {
            long p = in.nl();
            if(gcd%p == 0){
                out.println("YES");
                out.println(first + " " + (i+1));
                return;
            }
        }
        out.println("NO");
    }
}
