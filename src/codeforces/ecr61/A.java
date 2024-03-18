package codeforces.ecr61;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int cnt1 = in.ni(), cnt2=in.ni(), cnt3=in.ni(), cnt4=in.ni();
        if(cnt1 != cnt4 || cnt1 == 0 && cnt3 != 0){
            out.println(0);
        }else
            out.println(1);

    }
}
