package codeforces.r443;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] s = new int[n];
        int[] d = new int[n];
        for (int i = 0; i < n; i++) {
            s[i] = in.ni();d[i] = in.ni();
        }
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if(s[i] > cur)
                cur = s[i];
            else {
                int cnt = (cur-s[i])/d[i]+1;
                cur = s[i] + cnt*d[i];
            }
        }
        out.println(cur);
    }
}
