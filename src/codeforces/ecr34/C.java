package codeforces.ecr34;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        Arrays.sort(a);
        int len = 1;
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if(i == n || a[i] != a[i-1]){
                ans = Math.max(ans, len);
                len = 0;
            }
            len++;
        }
        out.println(ans);
    }
}
