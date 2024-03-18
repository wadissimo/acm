package codeforces.r545;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int len = 1;
        int prev = 0;
        int ans = 0;
        for (int i = 1; i < n+1; i++) {
            if(i == n || a[i] != a[i-1]){
                if(prev != 0){
                    ans = Math.max(ans, Math.min(prev, len)*2);
                }
                prev = len;
                len = 1;
            }else{
                len++;
            }
        }
        out.println(ans);
    }
}
