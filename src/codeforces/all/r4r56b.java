package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class r4r56b {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.nl();long k = in.nl();
        if(k == 1)
            out.println(n);
        else {
            int highest = Long.numberOfTrailingZeros(Long.highestOneBit(n));
            out.println((1L<<highest+1)-1);
        }
    }
}
