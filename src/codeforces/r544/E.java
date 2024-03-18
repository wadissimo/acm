package codeforces.r544;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        int[] a = in.na(n);
        Arrays.sort(a);
        int[] prev = new int[n];
        int left = 0, right = 0;
        while(right < n-1){
            right++;
            while(a[right] - a[left] > 5){
                left++;
            }
            prev[right] = left;
        }
//        System.out.println("Arrays.toString(a) = " + Arrays.toString(a));
//        System.out.println("Arrays.toString(prev) = " + Arrays.toString(prev));
        int[][] dp = new int[n+1][k+1];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Math.max(dp[i-1][j], dp[prev[i-1]][j-1] + i-prev[i-1]);
            }
        }
        int max = 0;
        for (int i = 0; i <= k ; i++) {
            max = Math.max(max, dp[n][i]);
        }
        out.println(max);

    }
}
