package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class r240A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        if(n == 1) {
            if(k == 0)
                out.println(1);
            else
                out.println(-1);
            return;
        }
        int pairs = n/2;
        if(k < pairs){
            out.println(-1);
            return;
        }
        int rem = k - pairs +1;
        out.print(rem + " " + (rem*2) + " ");
        int cur = rem*2;
        for (int i = 0; i < pairs - 1; i++) {
            out.print((cur+1) + " " + (cur + 2) + " ");
            cur+=2;
        }
        if(n%2 == 1)
            out.print((cur+1) + " ");
        out.println();



    }
}
