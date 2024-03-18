package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni(), M = in.ni();
        int[][] m1 = in.nmi(N, M);
        int[][] m2 = in.nmi(N, M);
        int[][] min = new int[N][M];
        int[][] max = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                min[i][j] = Math.min(m1[i][j], m2[i][j]);
                max[i][j] = Math.max(m1[i][j], m2[i][j]);
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if(i > 0){
                    if(min[i][j] <= min[i-1][j] || max[i][j] <= max[i-1][j]){
                        out.println("Impossible");
                        return;
                    }
                }
                if(j > 0){
                    if(min[i][j] <= min[i][j-1] || max[i][j] <= max[i][j-1]){
                        out.println("Impossible");
                        return;
                    }
                }
            }
        }
        out.println("Possible");
    }
}
