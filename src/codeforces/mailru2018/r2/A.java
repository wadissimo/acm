package codeforces.mailru2018.r2;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(); int s = in.ni()-1;
        int[] a = in.na(n);
        int[] b = in.na(n);
        if(a[0] == 0 || a[s] == 0 && b[s] == 0){
            out.println("NO");
        } else if(a[s] == 1){
            out.println("YES");
        } else {
            if(b[s] == 1)
                for (int i = s+1; i < n; i++) {
                    if(a[i] == 1 && b[i] == 1){
                        out.println("YES");
                        return;
                    }
                }
            out.println("NO");
        }
    }
}
