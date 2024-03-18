package codeforces.r494;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.math.BigDecimal;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(); int k = in.ni();
        int[] a = in.na(n);
        double max = 0.0;
        int[] pa = new int[n];
        pa[0] = a[0];
        for (int i = 1; i < n; i++) {
            pa[i] = pa[i-1]+a[i];
        }
        for (int i = k; i <= n; i++) {

            for (int j = 0; j < n - i + 1; j++) {
                double sum = pa[j+i-1];
                if(j>0)
                    sum-=pa[j-1];
                double avg = sum/(double)i;
                max = Math.max(avg, max);
            }
        }
        out.println(max);
    }
}
