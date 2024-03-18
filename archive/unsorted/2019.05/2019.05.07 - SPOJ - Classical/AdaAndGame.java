package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class AdaAndGame {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        int MAXN = 10_000;
        int MAXM = 100;
        boolean[][] dp = new boolean[MAXN][MAXM+1];
        int[][] moves = new int[MAXN][4];
        for (int i = 0; i < MAXN; i++) {
            int[] digs = new int[4];
            int num = i;
            int di = 0;
            while(num > 0){
                digs[di++] = num%10;
                num = num/10;
            }
            moves[i][0] = (digs[3]+1)%10*1000 + digs[2]*100+digs[1]*10+digs[0];
            moves[i][1] = digs[3]*1000 + (digs[2]+1)%10*100+digs[1]*10+digs[0];
            moves[i][2] = digs[3]*1000 + digs[2]*100+(digs[1]+1)%10*10+digs[0];
            moves[i][3] = digs[3]*1000 + digs[2]*100+digs[1]*10+(digs[0]+1)%10;

        }
        for (int t = 0; t < T; t++) {
            int N = in.ni(), M = in.ni();
            for (int i = 0; i <= N; i++) {
                dp[i][M] = false;// First lose
            }
            for (int i = N+1; i < MAXN ; i++) {
                dp[i][M] = true;
            }
            for(int i = M-1; i >= 0; i--){
                boolean first = i%2==0;
                for (int j = 0; j < MAXN; j++) {
                    if(first)
                        dp[j][i] = dp[moves[j][0]][i+1] || dp[moves[j][1]][i+1] || dp[moves[j][2]][i+1] || dp[moves[j][3]][i+1];
                    else
                        dp[j][i] = dp[moves[j][0]][i+1] && dp[moves[j][1]][i+1] && dp[moves[j][2]][i+1] && dp[moves[j][3]][i+1];
                }
            }
            if(dp[N][0])
                out.println("Ada");
            else
                out.println("Vinit");

        }
    }
}
