package codeforces.r478;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), q = in.ni();
        int[] a = in.na(n);
        long[] k = in.nal(q);
        long ksum = 0;
        long[] pref = new long[n+1];
        for (int i = 0; i < n; i++) {
            pref[i+1] = pref[i] + a[i];
        }
        for (int i = 0; i < q; i++) {
            ksum+= k[i];
            int left = 0;
            int right = n+1;
            while(left < right){
                int mid = (left+right)/2;
                if(pref[mid] <= ksum){
                    left = mid+1;
                } else {
                    right = mid;
                }
            }
            if(left == n+1){
                ksum = 0;
                left = 1;
            }
            out.println(n-left+1);
        }
    }
}
