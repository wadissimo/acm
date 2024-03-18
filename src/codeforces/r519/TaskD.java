package codeforces.r519;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskD {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(); int m = in.ni();
        int[][] a = new int[m][];
        for (int i = 0; i < m; i++) {
            a[i] = in.na(n);
        }
        int[] next = new int[n+1];
        for (int i = 0; i < n-1; i++) {
            next[a[0][i]] = a[0][i+1];
        }
        next[a[0][n-1]] = -1;
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n-1; j++) {
                if(next[a[i][j]] != a[i][j+1]){
                    next[a[i][j]] = -1;
                }
            }
            next[a[i][n-1]] = -1;
        }
        long ans = n;
        for (int i = 0; i < n; i++) {
            if(next[a[0][i]] != -1){
                long len = 0;
                int cur = a[0][i];
                while(cur != -1){
                    int prev = cur;
                    cur = next[cur];
                    next[prev] = -1;
                    len++;
                }
                ans += len*(len+1)/2-len;
            }
        }
        out.println(ans);
    }
}
