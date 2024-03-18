package codeforces.ffcelim;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == 'a')
                cnt++;
        }

        if(cnt == 0)
            out.println(0);
        else
            out.println(Math.min(s.length(), cnt*2-1));

    }
}
