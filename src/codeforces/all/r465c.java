package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class r465c {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long r = in.ni(), xc = in.ni(), yc= in.ni(), xn= in.ni(), yn=in.ni();

        long RR = (yc-yn)*(yc-yn) + (xc-xn)*(xc-xn);
        if(RR >= r*r){
            out.printf("%d %d %d%n", xc, yc, r);
        } else {
            if(RR == 0){
                out.printf("%f %f %f%n", xc+r/2.0, (double)yc, r/2.0);
                return;
            }
            double R = Math.sqrt(RR);
            double nR = (R+r)/2.0;
            double scale = nR/R;
            out.printf("%f %f %f%n", xn+scale*(xc-xn), yn+scale*(yc-yn), nR);
        }
    }
}
