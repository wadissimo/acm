package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class DRarityAndNewDress {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int m = in.ni();
        char[][] grid = in.nm(n, m);
        int[][] u = new int[n][m];
        int[][] d = new int[n][m];
        int[][] l = new int[n][m];
        int[][] r = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i > 0 && grid[i-1][j] == grid[i][j])
                    u[i][j] = u[i-1][j]+1;
                if(j > 0 && grid[i][j-1] == grid[i][j])
                    l[i][j] = l[i][j-1]+1;
            }
        }
        for (int i = n-1; i >= 0 ; i--) {
            for (int j = m-1; j >= 0; j--) {
                if(i < n-1 && grid[i+1][j] == grid[i][j])
                    d[i][j] = d[i+1][j]+1;
                if(j < m-1 && grid[i][j+1] == grid[i][j])
                    r[i][j] = r[i][j+1]+1;
            }
        }
        int[][] left = new int[n][m];
        int[][] right = new int[n][m];
        for (int j = 1; j < m; j++) {
            for (int i = 1; i < n-1; i++) {
                int min = 0;
                if(grid[i-1][j-1] == grid[i][j] && grid[i+1][j-1] == grid[i][j]){
                    min = Math.max(1, Math.min(left[i-1][j-1], left[i+1][j-1]));
                }
                left[i][j] = 1+Math.min(Math.min(l[i][j], r[i][j]), Math.min(u[i][j], d[i][j]));
                left[i][j] = Math.min(left[i][j], min + 2);
            }
        }
        for (int j = m-2; j >= 0; j--) {
            for (int i = 1; i < n-1; i++) {
                int min = 0;
                if(grid[i-1][j+1] == grid[i][j] && grid[i+1][j+1] == grid[i][j]){
                    min = Math.max(1, Math.min(right[i-1][j+1], right[i+1][j+1]));
                }
                right[i][j] = 1+Math.min(Math.min(l[i][j], r[i][j]), Math.min(u[i][j], d[i][j]));
                right[i][j] = Math.min(right[i][j], min + 2);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans += Math.max(1, Math.min(left[i][j], right[i][j]));
            }
        }
        out.println(ans);
    }
}
