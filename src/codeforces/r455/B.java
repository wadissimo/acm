package codeforces.r455;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int ans = 0;
        for (int i = n; i > 0 ; i-=2) {
            if(i == 1)
                ans += 1;
            else
                ans += i;
        }
        out.println(ans);
    }
}
