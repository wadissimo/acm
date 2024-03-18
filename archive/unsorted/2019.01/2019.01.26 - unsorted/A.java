package codeforces.ecr59;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int q = in.ni();
        for (int i = 0; i < q; i++) {
            int n = in.ni();
            String s = in.ns();
            if(n == 2){
                if(s.charAt(0) < s.charAt(1)){
                    out.println("YES");
                    out.println(2);
                    out.println(s.charAt(0) + " " + s.charAt(1));
                } else {
                    out.println("NO");
                }
            } else {
                out.println("YES");
                out.println(2);
                out.println(s.charAt(0) + " " + s.substring(1, n));
            }
        }
    }
}
