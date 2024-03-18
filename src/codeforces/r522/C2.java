package codeforces.r522;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C2 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        boolean[][] dp = new boolean[n][5];
        int[][] path = new int[n][5];
        for (int i = 0; i < 5; i++) {
            dp[n-1][i] = true;
        }
        for (int i = n-2; i >= 0; i--) {
            if(a[i] < a[i+1]){
                for (int j = 1; j < 5; j++) {
                    if(dp[i+1][j]){
                        for (int k = 0; k < j; k++) {
                            dp[i][k] = true;
                            path[i][k] = j;
                        }
                    }
                }
            } else if(a[i] > a[i+1]){
                for (int j = 0; j < 4; j++) {
                    if(dp[i+1][j]){
                        for (int k = j+1; k < 5; k++) {
                            dp[i][k] = true;
                            path[i][k] = j;
                        }
                    }
                }
            } else {
                for (int j = 0; j < 5; j++) {
                    int diff = -1;
                    for (int k = 0; k < 5; k++) {
                        if(k!=j && dp[i+1][k]){
                            diff = k;
                        }
                    }
                    if(diff != -1){
                        dp[i][j] = true;
                        path[i][j] = diff;
                    }
                }
            }
        }
        int curr;
        for (int x = 0; x < 5; x++) {
            if(dp[0][x]){
                curr = x;
                boolean correct = true;
                StringBuilder sb = new StringBuilder();
                sb.append(curr+1);
                for (int i = 0; i < n-1; i++) {
                    if(!dp[i][curr]){
                        correct = false;
                        break;
                    }
                    curr = path[i][curr];
                    sb.append(" ").append(curr+1);

                }
                if(correct){
                    out.println(sb.toString());
                    return;
                }
            }
        }
        out.println(-1);
    }
}
