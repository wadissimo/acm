package codeforces.r528;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        int n = s.length();
        int mid = n/2-1;
        if(n%2 == 1)
            mid++;
        StringBuilder sb = new StringBuilder();
        sb.append(s.charAt(mid));
        int rem = n-1;
        int i = 0;
        while (rem > 0) {
            sb.append(s.charAt(mid+i+1));
            rem --;
            if(rem == 0) break;
            sb.append(s.charAt(mid-i-1));
            rem--;
            i++;
        }
        out.println(sb.toString());
    }
}
