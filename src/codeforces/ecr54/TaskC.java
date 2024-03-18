package codeforces.ecr54;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int d = in.ni();
            double D = d*d - 4*d;
            if(D >=0){
                double x1 = 0.5 *(d + Math.sqrt(D));
                double x2 = 0.5 *(d - Math.sqrt(D));
                if(x1 >= 0 && d-x1 >= 0){
                    out.println("Y " + x1 + " " + (d-x1));
                    continue;
                } else if (x2 >= 0 && d-x2 >= 0){
                    out.println("Y " + x2 + " " + (d-x2));
                    continue;
                }
            }
            out.println("N");
        }
    }
}
