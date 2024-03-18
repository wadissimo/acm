package codeforces.r551;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), t = in.ni();
        int MAX = 300_000;
        int[] tt = new int[MAX];
        Arrays.fill(tt, -1);
        for (int i = 0; i < n; i++) {
            int s = in.ni();
            int d = in.ni();
            int cur = s;
            while(cur < MAX){
                tt[cur] = i;
                cur+=d;
            }
        }
        int cur = t;
        while(tt[cur] == -1){
            cur++;
        }
        out.println(tt[cur]+1);
    }
}
