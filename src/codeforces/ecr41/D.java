package codeforces.ecr41;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class D {
    int n;
    int[] x;
    int[] y;
    boolean test(long a, long b, long c){
        Long x1 = null, x2 = null, y1 = null, y2 = null;
        long a2 = 0, b2 = 0, c2 = 0;
        for (int i = 0; i < n; i++) {
            if(a*x[i] + b*y[i] + c != 0){
                if(x1 == null){
                    x1 = (long)x[i]; y1 = (long)y[i];
                } else if(x2 == null){
                    x2 = (long)x[i]; y2 = (long)y[i];
                    a2 = y2 - y1;
                    b2 = x1 - x2;
                    c2 = -a2*x2 - b2*y2;
                } else if(a2*x[i] + b2*y[i] + c2 != 0){
                    return false;
                }
            }
        }
        return true;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        n = in.ni();
        x = new int[n];
        y = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni(); y[i] = in.ni();
        }
        if(n < 5){
            out.println("YES");
        } else {
            int[] xa = new int[]{x[0], x[0], x[1]};
            int[] xb = new int[]{x[1], x[2], x[2]};
            int[] ya = new int[]{y[0], y[0], y[1]};
            int[] yb = new int[]{y[1], y[2], y[2]};
            for (int i = 0; i < 3; i++) {
                long a = yb[i] - ya[i];
                long b = xa[i] - xb[i];
                long c = -a*xb[i] - b*yb[i];
                if(test(a, b, c)){
                    out.println("YES");
                    return;
                }
            }
            out.println("NO");

        }



    }
}
