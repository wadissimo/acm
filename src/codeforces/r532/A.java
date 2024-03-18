package codeforces.r532;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        int[] a = in.na(n);
        int ans = 0;
        for (int b = 0; b < k; b++) {
            int pos = 0, neg = 0;
            for (int i = 0; i < n; i++) {
                if(i%k != b){
                    if(a[i] > 0)
                        pos ++;
                    else
                        neg++;
                }
            }
            ans = Math.max(ans, Math.abs(pos-neg));
        }
        out.println(ans);
    }
}
