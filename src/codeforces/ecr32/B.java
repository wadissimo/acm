package codeforces.ecr32;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        int x = 0, y = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == 'R')
                x++;
            else if(c == 'L')
                x--;
            else if(c=='U')
                y++;
            else if(c== 'D')
                y--;
        }
        int dist = Math.abs(x)+ Math.abs(y);
        out.println(n-dist);
    }
}
