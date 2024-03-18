package codeforces.ecr56;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni();
            if(n <= 7){
                out.println(1);
            } else{
                out.println(n/7 + ((n%7 == 0)?0:1));
            }
        }
    }
}
