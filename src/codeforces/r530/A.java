package codeforces.r530;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int w = in.ni(), h = in.ni();
        int u1 = in.ni(), d1 = in.ni();
        int u2 = in.ni(), d2 = in.ni();
        if(d1 < d2){
            int t = d1;
            d1 = d2;
            d2 = t;
            t = u1;
            u1=u2;
            u2= t;
        }
        int sum = w;
        for (int i = d1; i <= h; i++) {
            sum += i;
        }
        sum -= u1;
        if(sum < 0)
            sum = 0;
        for (int i = d2; i < d1; i++) {
            sum += i;
        }
        sum -= u2;
        if(sum <0)
            sum = 0;
        for (int i = 0; i < d2; i++) {
            sum+=i;
        }
        out.println(sum);

    }
}
