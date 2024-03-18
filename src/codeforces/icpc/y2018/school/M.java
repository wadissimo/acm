package codeforces.icpc.y2018.school;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class M {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(); int k = in.ni();
        int[] a = in.na(n);
        int[] ans = new int[n];
        for (int i = 1; i < n; i++) {
            if(a[i] != a[i-1]){
                ans[i] = ans[i-1]+1;
            }
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, ans[i]);
        }
        out.println(max+1);

    }
}
