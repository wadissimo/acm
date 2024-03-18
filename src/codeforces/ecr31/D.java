package codeforces.ecr31;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        if(n==1){
            out.println(0);
            return;
        } else if(n <= 3){
            out.println(n);
            return;
        }
        if(n > 1000){
            Random r = new Random();
            for (int i = 0; i < n / 2; i++) {
                int x = r.nextInt(n), y = r.nextInt(n-1);
                if(y >= x)
                    y++;
                int t = a[x];
                a[x] = a[y];
                a[y] = t;
            }
        }
        Arrays.sort(a);
        long[] pref = new long[n+1];
        for (int i = 0; i < n; i++) {
            pref[i+1] = pref[i] + a[i];
        }
        int rem = n;







    }
}
