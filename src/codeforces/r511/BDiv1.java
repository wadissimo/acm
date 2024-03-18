package codeforces.r511;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class BDiv1 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.ni(), m = in.ni();
        if(n>m){
            long t = n;
            n = m;
            m = t;
        }
        if(n==1){
            if(m%6 == 0)
                out.println(m);
            else if(m%6 == 1)
                out.println(m-1);
            else if(m%6 == 2)
                out.println(m-2);
            else if(m%6 == 3)
                out.println(m-3);
            else if(m%6 == 4)
                out.println(m-2);
            else if(m%6 == 5){
                out.println(m-1);
            }
        } else if(n == 2){
            if(m==2)
                out.println(0);
            else if(m == 3)
                out.println(4);
            else if(m==7)
                out.println(12);
            else
                out.println(m*2);
        } else {
            if(n*m %2 == 1){
                out.println(n*m-1);
            } else {
                out.println(n*m);
            }
        }
    }
}
