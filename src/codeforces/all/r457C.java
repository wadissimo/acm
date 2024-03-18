package codeforces.all;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.ArrayList;

public class r457C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int p = 100069;
        int n = in.ni(), m = in.ni();
        out.println(p + " " + p);
        out.println("1 2 " + (p - n + 2));
        for (int i = 2; i < n; i++) {
            out.println(i + " " + (i+1) + " 1");
        }
        m-=n-1;
        int cur = 1;
        while(m > 0) {
            for (int j = cur + 2; j <= n && m > 0; j++) {
                out.println(cur + " " + j + " " + (p+1));
                m--;
            }
            cur++;
        }
    }
}
