package codeforces.ecr57;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int ang = in.ni();
            int gcd = (int)IntegerUtils.gcd(180, ang);
            int n = 180/gcd;
            int l = ang/gcd;
            if(l<n-1)
                out.println(n);
            else
                out.println(n*2);
        }
    }
}
