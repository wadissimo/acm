package codeforces.r450;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int a = in.ni(), b = in.ni(), c = in.ni();
        int cur = a;
        int max = 1_000_000;
        for (int i = 0; i < max; i++) {
            cur *= 10;
            int d = cur/b;
            if(d == c){
                out.println(i+1);
                return;
            }
            cur = cur%b;
        }
        out.println(-1);
    }
}
