package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class Seinfeld {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        int MAX = 2007;
        int[] dp = new int[MAX];
        int[] next = new int[MAX];
        int t = 1;
        while(s.charAt(0) != '-') {
            int n = s.length();
            for (int i = 1; i <= n; i++) {
                dp[i] = MAX;
            }
            dp[0] = 0;
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                if(c == '{'){
                    next[0] = MAX;
                    for (int j = 0; j < n; j++) {
                        next[j+1] = dp[j];
                    }
                    for (int j = 1; j <= n; j++) {
                        next[j-1] = Math.min(next[j-1], dp[j]+1);
                    }
                } else {
                    for (int j = 1; j <=n; j++) {
                        next[j-1] = dp[j];
                    }
                    next[n] = MAX;
                    for (int j = 0; j < n; j++) {
                        next[j+1] = Math.min(next[j+1], dp[j]+1);
                    }
                }
                for (int j = 0; j <= n; j++) {
                    dp[j] = next[j];
                }
            }
            out.printf("%d. %d%n", t, dp[0]);

            t++;
            s = in.ns();
        }
    }
}
