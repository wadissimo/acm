package codeforces.r454;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int v1 = in.ni(), v2 = in.ni(), v3 = in.ni(), vm = in.ni();
        if(vm >= v2 || vm > v3*2 || 2*vm < v3){
            out.println(-1);
        } else {
            out.println(2*v1);
            out.println(2*v2);
            out.println(Math.min(vm,v3)*2);

        }
    }
}
