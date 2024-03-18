package codeforces.r446;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] l = in.na(n);
        boolean[] killed = new boolean[n];
        int[]ll = new int[n];
        Arrays.fill(ll, -1);
        for (int i = 0; i < n; i++) {
            if(l[i] > 0){
                int pos = Math.max(0, i-l[i]);
                ll[pos] = Math.max(ll[pos], i-1);
            }
        }
        int cur = -1;
        for (int i = 0; i < n; i++) {
            if(ll[i] != -1){
                cur = Math.max(cur, ll[i]);
            }
            if(cur >= i)
                killed[i] = true;
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(!killed[i])
                ans++;
        }
        out.println(ans);
    }
}
