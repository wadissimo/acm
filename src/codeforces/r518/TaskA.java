package codeforces.r518;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.math.BigInteger;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.nl();long m = in.nl();long k = in.nl(); long l = in.nl();
        BigInteger kl = BigInteger.valueOf(k).add(BigInteger.valueOf(l));
        BigInteger bm = BigInteger.valueOf(m);
        BigInteger[] res = kl.divideAndRemainder(bm);
        BigInteger x = res[0];
        if(res[1].compareTo(BigInteger.ZERO) != 0)
            x = x.add(BigInteger.ONE);
        if(x.multiply(bm).compareTo(BigInteger.valueOf(n)) > 0)
            out.println(-1);
        else
            out.println(x.toString());
    }
}
