package codeforces.r445;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = 6;
        int[] a = in.na(n);
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum+=a[i];
        }
        if(sum%2 != 0){
            out.println("NO");
            return;
        }
        sum /= 2;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j <n ; j++) {
                for (int k = j+1; k < n; k++) {
                    if(a[i]+a[j]+a[k] == sum){
                        out.println("YES");
                        return;
                    }
                }
            }
        }
        out.println("NO");
    }
}
