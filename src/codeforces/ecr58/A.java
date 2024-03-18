package codeforces.ecr58;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int q = in.ni();
        for (int i = 0; i < q; i++) {
            int l = in.ni(), r = in.ni(), d = in.ni();
            if(d <l || d>r){
                out.println(d);
            } else{
                out.println((r/d + 1)*d);
            }
        }
    }
}
