package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class ECR62B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni();
            String s = in.ns();
            int first = -1;
            int last = -1;
            for (int i = 0; i < n; i++) {
                if(s.charAt(i) == '<'){
                    last = i;
                } else {
                    if(first == -1)
                        first = i;
                }
            }
            if(last == -1 || first == -1)
                out.println(0);
            else
                out.println(Math.min(n-last-1, first));
        }
    }
}
