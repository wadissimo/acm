package codeforces.ecr32;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class E {
    private long[] getSums(int[] a, int from, int to, long mod){
        int n = to-from;
        long[] res = new long[1<<n];
        for (int mask = 0; mask < 1 << n; mask++) {
            long sum = 0;
            for (int i = 0; i < n; i++) {
                if((mask&(1<<i)) > 0){
                    sum += a[from+i];
                }
            }
            res[mask] = sum%mod;
        }
        return res;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        long mod = m;
        int[] a = in.na(n);
        for (int i = 0; i < n; i++) {
            a[i] %= m;
        }
        if(n == 1){
            out.println(a[0]);
            return;
        }
        long[] p1 = getSums(a, 0, n/2, mod);
        long[] p2 = getSums(a, n/2, n, mod);
        Arrays.sort(p1);
        Arrays.sort(p2);
//        System.out.println("Arrays.toString(p1) = " + Arrays.toString(p1));
//        System.out.println("Arrays.toString(p2) = " + Arrays.toString(p2));
        long ans = 0;
        int right = p2.length-1;
        for (int i = 0; i < p1.length; i++) {
            while(right >= 0 && p1[i]+p2[right] >= mod){
                right--;
            }
            ans = Math.max(ans, (p1[i]+p2[right]));
        }
        out.println(ans);

    }
}
