package codeforces.ecr38;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int x = in.ni();
            if(x == 0){
                out.println("1 1");
                continue;
            }
            boolean found = false;
            for (int div = 1; div*div < x ; div++) {
                if(x%div == 0 && (div + x/div)%2 ==0 && (x/div - div)%2 == 0){
                    int n = (div + x/div)/2;
                    int b = (x/div - div)/2;
                    int m = n/b;
                    if(n/m == b){
                        out.println(n + " " + m);
                        found = true;
                        break;
                    }
                }
            }
            if(!found)
                out.println(-1);
        }
    }
}
