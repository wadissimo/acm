package codeforces.r537;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;

public class C {
    long[] a;
    int A;
    int B;
    int cnt(long to){
        if(to == 0){
            return 0;
        }
        int left = 0, right = a.length;
        while(left < right){
            int mid = (left+right)/2;
            if(a[mid] <= to){
                left = mid+1;
            } else
                right = mid;
        }
        return left;
    }

    long go(long from, long to){
        int cnt = cnt(to) - cnt(from-1);
        if(cnt == 0)
            return A;
        long val = B*cnt*(to-from+1);
        if(from == to){
            return val;
        }
        long mid = (to+from)/2;
        return Math.min(val, go(from, mid) + go(mid+1, to));
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int k = in.ni();
        A = in.ni();
        B = in.ni();

        a = in.nal(k);
        if(k > 1000){
            Random r = new Random();
            for (int i = 0; i < n / 2; i++) {
                int x = r.nextInt(n);
                int y = r.nextInt(n-1);
                if(y>=x) y++;
                long t = a[x];
                a[x] = a[y];
                a[y] = t;
            }
        }
        Arrays.sort(a);
        long ans = go(1, 1L<<n);
        out.println(ans);
    }
}
