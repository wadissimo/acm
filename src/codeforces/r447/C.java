package codeforces.r447;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] s = in.na(n);
        int gcd = s[0];
        for (int i = 0; i < n; i++) {
            if(s[i]%gcd != 0){
                out.println(-1);
                return;
            }
        }
        out.println(3*n);
        for (int i = 0; i < n; i++) {
            out.print(gcd + " " + s[i] + " " + s[i] + " ");
        }
        out.println();


    }
}
