package main;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;
import java.util.Arrays;

public class CoderExpress3 {

    int INF = 2000;

    private int binarySearch(int[] a, int value) {
        int left = 0, right = a.length;
        while (left < right) {
            int mid = (right + left) / 2;
            if (a[mid] <= value) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    int[] dp(int[] a){
        int N = a.length;
        int[] dp = new int[N+1];
        Arrays.fill(dp, INF);
        dp[0] = -INF;
        int[] inc = new int[N];
        for (int i = 0; i < N; i++) {
            int j = binarySearch(dp, a[i]);
            if(i > 0)
                inc[i] = inc[i-1];
            if(dp[j] > a[i] && dp[j-1] < a[i]){
                dp[j] = a[i];
                inc[i] = Math.max(inc[i], j);
            }
        }
        return inc;
    }
    int[] reverse(int[] a){
        int N = a.length;
        int[] b = new int[N];
        for (int i = 0; i < N; i++) {
            b[i] = a[N-i-1];
        }
        return b;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();

        for (int t = 0; t < T; t++) {
            int N = in.ni();
            int[] a = in.na(N);

            int[] inc = dp(a);
            int[] rev = reverse(a);
            int[] dec = dp(rev);
            int ans = 0;
            for (int i = 0; i < N; i++) {
                ans = Math.max(ans, inc[i]-1 + dec[N-i-1]);
            }

//            System.out.println("Arrays.toString(dp) = " + Arrays.toString(dp));
//            System.out.println("Arrays.toString(dpDown) = " + Arrays.toString(dpDown));
            out.println(ans);
        }


    }
}

