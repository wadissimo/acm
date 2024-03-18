package codeforces.r555;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class G {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        int[][] a = new int[n][];
        for (int i = 0; i < n; i++) {
            a[i] = in.na(m);
        }
        boolean[] col = new boolean[m];
        boolean[] row = new boolean[m];
        for (int j = 0; j <= m ; j++) {
            for (int i = 0; i < j ; i++) {
                col[i] = a[0][i] == 1;
            }
            for (int i = j; i < m; i++) {
                col[i] = a[0][i] == 0;
            }
            for (int r = 1; r < n; r++) {
                boolean invalid = false;
                for (int i = 0; i < 2; i++) {
                    if(i == 1)
                        row[r] = true;
                    else
                        row[r] = false;
                    for (int c = 0; c < m; c++) {

                    }
                }
            }
        }
        
    }
}
