package codeforces.r542;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n*2);
        int[] c1 = new int[n+1];
        int[] c2 = new int[n+1];
        Arrays.fill(c1, -1);
        c1[0] = c2[0] = 0;

        for (int i = 0; i < 2 * n; i++) {
            if(c1[a[i]] == -1){
                c1[a[i]] = i;
            } else
                c2[a[i]] = i;
        }
        long dist = 0;
        for (int i = 1; i <=n; i++) {
            dist += Math.min(Math.abs(c2[i]-c2[i-1]) + Math.abs(c1[i]-c1[i-1]),Math.abs(c2[i]-c1[i-1]) + Math.abs(c1[i]-c2[i-1]));
        }
        out.println(dist);
    }
}
