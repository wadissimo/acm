package codeforces.icpc.y2018.school;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int [] m = new int[n];
        int []mx = new int[n];
        long maxmax = 0;
        for (int i = 0; i < n; i++) {
            m[i] = in.ni();
            int max = 0;
            for (int j = 0; j < m[i]; j++) {
                max = Math.max(in.ni(), max);
            }
            mx[i] = max;
            maxmax = Math.max(maxmax, max);
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += (maxmax-mx[i])*(long)m[i];
        }
        out.println(ans);
    }
}
