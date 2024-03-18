package codeforces.mailru2018.r2;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long la = in.ni(); long ra = in.ni(); long ta = in.ni();
        long lb = in.ni(); long rb = in.ni(); long tb = in.ni();
        long lena = ra-la+1;
        long lenb = rb-lb+1;
        long gcd = IntegerUtils.gcd(ta, tb);
        long d = (lb-la+ta)%ta;
        long minPos = d%gcd;
        long max1 = Math.min(lena - minPos, lenb);
        d = (la-lb+tb)%tb;
        minPos = d%gcd;
        long max2 = Math.min(lenb-minPos, lena);
        long max = Math.max(max1, max2);
        if(max < 0)
            max = 0;
        out.println(max);

    }
}
