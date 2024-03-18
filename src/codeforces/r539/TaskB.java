package codeforces.r539;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        boolean[] p = new boolean[101];
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum +=a[i];
            p[a[i]] = true;
        }
        int max = 0;
        for (int i = 1; i <=100; i++) {
            for (int j = 1; j <= 100; j++) {
                if(p[i] && p[j] && i!=j){
                    for (int k = 2; k*k <= i; k++) {
                        if(i%k == 0){
                            max = Math.max(max, i+j - i/k - j*k);
                        }
                    }

                }
            }
        }
        out.println(sum - max);
    }
}
