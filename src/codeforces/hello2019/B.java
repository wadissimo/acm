package codeforces.hello2019;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int max = 1<<n;
        for (int mask = 0; mask < max; mask++) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if((mask & (1<<i)) != 0){
                    sum += a[i];
                } else
                    sum -= a[i];
            }
            if(sum%360 == 0){
                out.println("YES");
                return;
            }
        }
        out.println("NO");
    }
}
