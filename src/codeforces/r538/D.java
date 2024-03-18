package codeforces.r538;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] c = in.na(n);
        int[][] dp = new int[n+1][n+1];
        for (int i = 0; i < n - 1; i++) {
            if(c[i] != c[i+1]){
                dp[i][2] = 1;
            }
        }
        int[] left = new int[n];
        int[] right = new int[n];
        for (int i = 1; i < n; i++) {
            if(c[i] == c[i-1])
                left[i]=left[i-1];
            else
                left[i] = i;
        }
        for(int i = n-2; i>=0;i--){
            if(c[i] == c[i+1])
                right[i] = right[i+1];
            else
                right[i] = i;
        }
        for (int len = 3; len < n; len++) {
            for (int i = 0; i < n - len + 1; i++) {
                if(c[i] == c[i+len-1]){
                    if(right[i] < left[i+len-1])
                        dp[i][len] = dp[right[i]+1][left[i+len-1]-right[i]-1]+1;
                }
            }
        }
    }
}
