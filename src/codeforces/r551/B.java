package codeforces.r551;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni(), h = in.ni();
        int[] a = in.na(m);
        int[] b = in.na(n);
        int[][] g = in.nmi(n, m);
        int[][] ans = new int[n][m];
        int[][] max = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(g[i][j] == 1){
                    max[i][j] = Math.min(a[j], b[i]);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(max[i][j] + " ");
            }
            out.println();
        }
    }
}
