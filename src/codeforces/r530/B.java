package codeforces.r530;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int i = 1;
        for (; i*i < n; i++) {
        }
        if((i-1)*i >=n){
            out.println(2*i-1);
        } else {
            out.println(2*i);
        }
    }
}
