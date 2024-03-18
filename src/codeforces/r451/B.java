package codeforces.r451;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int a = in.ni(), b = in.ni();
        for (int i = 0; i <= n / a; i++) {
            if((n-i*a)%b == 0){
                out.println("YES");
                out.println(i + " " + ((n-i*a)/b));
                return;
            }
        }
        out.println("NO");
    }
}
