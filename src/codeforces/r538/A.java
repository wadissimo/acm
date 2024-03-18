package codeforces.r538;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int x = in.ni(), y = in.ni(), z = in.ni();
        int a = in.ni(), b = in.ni(), c = in.ni();
        a-=x;
        if(a < 0 || a+b < y || a+b+c <y+z){
            out.println("NO");
        } else {
            out.println("YES");
        }

    }
}
