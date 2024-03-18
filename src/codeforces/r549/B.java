package codeforces.r549;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.math.BigInteger;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        if(n < 10){
            out.println(n);
            return;
        }
        String s = Integer.toString(n);
        long best = BigInteger.valueOf(9).pow(s.length()-1).longValue();
        long prev = 1;
        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i)-'0';
            if(d == 0)
                break;
            if(d == 1)
                continue;
            long cur = prev*(d-1)*BigInteger.valueOf(9).pow(s.length()-i-1).longValue();
            if(cur > best)
                best = cur;
            prev*=d;
        }
        if(prev > best)
            best = prev;
        out.println(best);
    }
}
