package codeforces.ecr32;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.ni(), k = in.ni();
        if(k == 1){
            out.println(1);
            return;
        }
        long ans2 = 1 + (n-1)*n/2; //k ==2;
        long ans3 = ans2 + (n-1)*n*(n-2)/3; //k == 3;
        long ans4 = ans3 + n*(n-1)*(n-2)*(n-3)/8*3;
        if(k == 2){
            out.println(ans2);
        } else if(k == 3){
            out.println(ans3);
        } else {
            out.println(ans4);
        }


    }
}
