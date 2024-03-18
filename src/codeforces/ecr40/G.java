package codeforces.ecr40;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class G {
    int n;
    int r;
    long[] a;
    long k;
    long[] b;
    long MAX = 2_000_000_000_000_000_000L;
    boolean check(long l){
        long rem = k;
        Arrays.fill(b, 0);
        long sum = 0;
        long delta;
        for (int i = 0; i < n; i++) {
            if(i+r < n)
                sum += b[i+r];
            delta = l-a[i]-sum;
            if(delta > 0){
                b[Math.min(i+r, n-1)] += delta;
                sum+= delta;
                rem-= delta;
                if(rem < 0){
                    return false;
                }
            }
            if(i-r >= 0)
                sum -= b[i-r];
        }
        return true;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        n = in.ni();
        r = in.ni();
        k = in.nl();
        a = in.nal(n);
        b = new long[n];
        long[] pref = new long[n+1];
        for (int i = 0; i < n; i++) {
            pref[i+1] = pref[i] + a[i];
        }
        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i-r);
            int right = Math.min(n-1, i+r);
            a[i] = pref[right+1] - pref[left];
        }

        long left = 0;
        long right = MAX;
        while(left < right){
            long mid = (left+right+1)/2;
            boolean res = check(mid);
            if(res) {
                left = mid;
            } else {
                right = mid-1;
            }
        }
        out.println(left);

    }
}
