package codeforces.g2;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class D {
    public void randomShuffle(long[] a){
        Random rand = new Random();
        int n = a.length;
        for (int i = 0; i < n; i++) {
            int x = rand.nextInt(n);
            int y = rand.nextInt(n-1);
            if(y >= x)
                y++;
            long t = a[x];
            a[x] = a[y];
            a[y] = t;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        long[] s = in.nal(n);
        //todo: n == 1
        if(n > 1000)
            randomShuffle(s);
        Arrays.sort(s);
        long[] gap = new long[n-1];
        for (int i = 0; i < n-1; i++) {
            gap[i] = s[i+1]-s[i];
        }
        if(n > 1000)
            randomShuffle(gap);
        Arrays.sort(gap);
        long[] pref = new long[n];
        for (int i = 0; i < n-1; i++) {
            pref[i+1] = pref[i] + gap[i];
        }
        int Q = in.ni();
        for (int q = 0; q < Q; q++) {
            long l = in.nl(), r = in.nl();
            long size = r-l+1;
            int left = 0, right = n-1;
            while(left < right){
                int mid = (left+right)/2;
                if(gap[mid] <= size)
                    left = mid+1;
                else
                    right = mid;
            }
            int cnt = n-1-left;
            long used = (long)cnt*size + pref[left] + size;
            out.print(used + " ");
        }


    }
}
