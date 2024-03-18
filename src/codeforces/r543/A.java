package codeforces.r543;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni(), k = in.ni();
        int[] p = in.na(n);
        int[] s = in.na(n);
        int[] c = in.na(k);
        boolean[] chosen = new boolean[n];
        for (int i = 1; i <= m; i++) {
            int max = 0;
            int id = 0;
            for (int j = 0; j < n; j++) {
                if(s[j] == i){
                    if(p[j] > max){
                        max = p[j];
                        id = j;
                    }
                }
            }
            chosen[id] = true;
        }
        int ans = 0;
        for (int i = 0; i < k; i++) {
            if(!chosen[c[i]-1])
                ans++;
        }
        out.println(ans);
    }
}
