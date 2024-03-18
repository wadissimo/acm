package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class Assignments {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        ArrayList<Integer>[] masks = new ArrayList[21];
        for (int i = 0; i < 21; i++) {
            masks[i] = new ArrayList<>();
        }
        for (int mask = 0; mask < (1 << 20); mask++) {
            masks[Integer.bitCount(mask)].add(mask);
        }
        long[] dp = new long[(1<<20) + 7];
        for (int t = 0; t < T; t++) {
            int N = in.ni();
            int[][] a = new int[N][];
            int[] aMask = new int[N];
            for (int i = 0; i < N; i++) {
                a[i] = in.na(N);
                for (int j = 0; j < N; j++) {
                    if(a[i][j] == 1){
                        aMask[i] |= (1<<j);
                    }
                }
            }
            Arrays.fill(dp, 0);
            dp[0] = 1;
            int ones = (1<<N)-1;
            for (int i = 0; i < N; i++) {
                for (int mask : masks[i]) {
                    if(((ones-mask)&aMask[i]) > 0) {
                        for (int j = 0; j < N; j++) {
                            if(a[i][j] == 1 && (mask&(1<<j)) == 0){
                                dp[mask|(1<<j)] += dp[mask];
                            }
                        }
                    }
                }
            }
            out.println(dp[ones]);


        }
    }
}
