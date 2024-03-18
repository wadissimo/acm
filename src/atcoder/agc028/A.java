package atcoder.agc028;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(),m = in.ni();
        String s = in.ns(), t = in.ns();
        long gcd = IntegerUtils.gcd(n, m);
        long lcm = (long)n/gcd*m;
        boolean valid = true;
        for (int i = 0; i < gcd; i++) {
            if(s.charAt((int)(n/gcd*i)) != t.charAt((int)(m/gcd*i))){
                valid = false;
                break;
            }
        }
        if(!valid)
            out.println(-1);
        else
            out.println(lcm);
    }
}
