package codeforces.r531;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), x = in.ni(), y = in.ni();
        int [] a = in.na(n);
        if(x > y){
            out.println(n);
        } else {
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if(a[i] <= x)
                    cnt++;
            }
            out.println(cnt/2 + cnt%2);
        }
    }
}
