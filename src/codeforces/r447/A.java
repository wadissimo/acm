package codeforces.r447;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        int n = s.length();

        int cur = 0;
        long total = 0;
        long ans = 0;
        for (int i = n-1; i >=0 ; i--) {
            char c = s.charAt(i);
            if(c == 'Q') {
                cur++;
                ans += total;
            }else if(c=='A') {
                total += cur;
            }
        }
        out.println(ans);
    }
}
