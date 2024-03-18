package codeforces.r483;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] from = new int[n];
        int[] to = new int[n];
        for (int i = 0; i < n; i++) {
            from[i] = in.ni()-1;to[i] = in.ni()-1;
        }
        int dp[][][][] = new int[n+1][10][5][1024];
        for (int i = 0; i < n+1; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 5; k++) {
                    for (int l = 0; l < 1024; l++) {
                        dp[i][j][k][l] = Integer.MAX_VALUE;
                    }
                }
            }
        }
        dp[0][0][0][0] = 0;
        for (int i = 0; i < n+1; i++) {
            for (int ppl = 4; ppl >=0; ppl--) {
                for (int mask = 0; mask < 1024; mask++) {
                    if(Integer.bitCount(mask) > ppl)
                        continue;
                    for (int floor = 0; floor < 10; floor++) {
                        if(ppl > 0 && (mask&(1<<floor)) != 0){
                            dp[i][floor][ppl-1][mask^(1<<floor)] = Math.min(dp[i][floor][ppl-1][mask^(1<<floor)], dp[i][floor][ppl][mask]+1);
                            if(Integer.bitCount(mask) < ppl)
                                dp[i][floor][ppl-1][mask] = Math.min(dp[i][floor][ppl-1][mask], dp[i][floor][ppl][mask]+1);
                        }
                        if(ppl < 4 && i < n && from[i] == floor){
                            //dp[i+1][floor][ppl+1][mask|(1<<to[i])]
                        }
                        for (int nextfloor = 0; nextfloor < 10; nextfloor++) {

                        }

                    }
                }
            }
        }
    }
}
