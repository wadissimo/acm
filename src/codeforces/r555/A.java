package codeforces.r555;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = Integer.toString(n);
        int sn = s.length();
        int ans = 9;
        for (int i = sn-1; i > 0; i--){
            int d = s.charAt(i)-'0';
            if(i != sn-1)
                d++;
            ans += 10-d;
        }
        out.println(ans);
    }
}
