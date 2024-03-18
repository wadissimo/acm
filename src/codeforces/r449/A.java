package codeforces.r449;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();int m = in.ni();
        String  s = in.ns();
        char[] a = s.toCharArray();
        for (int i = 0; i < m; i++) {
            int l = in.ni()-1, r = in.ni()-1;char src = in.ns().charAt(0); char tgt = in.ns().charAt(0);
            for (int j = l; j <= r; j++) {
                if(a[j] == src)
                    a[j] = tgt;
            }
        }
        out.println(new String(a));
    }
}
