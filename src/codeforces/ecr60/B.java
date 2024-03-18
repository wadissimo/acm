package codeforces.ecr60;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni(), k = in.ni();
        int[] a = in.na(n);
        long max = 0, max2 = 0;
        for (int i = 0; i < n; i++) {
            if(a[i] >= max){
                max2 = max;
                max = a[i];
            } else{
                max2 = Math.max(max2, a[i]);
            }
        }
        int cnt = m/(k+1);
        int rem = m-cnt*(k+1);
        out.println(max*cnt*k + max2*cnt + max*rem);
    }
}
