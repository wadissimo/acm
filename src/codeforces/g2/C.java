package codeforces.g2;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        int[][] a = new int[n][];
        int[][] b = new int[n][];
        for (int i = 0; i < n; i++) {
            a[i] = in.na(m);
        }
        for (int i = 0; i < n; i++) {
            b[i] = in.na(m);
        }
        for (int row = 0; row < n; row++) {
            int av = 0, bv = 0;
            for (int i = 0; i < m; i++) {
                av+=a[row][i];
                bv+=b[row][i];
            }
            if(av%2 != bv%2){
                out.println("No");
                return;
            }
        }
        for (int col = 0; col < m; col++) {
            int av = 0, bv = 0;
            for (int i = 0; i < n; i++) {
                av+=a[i][col];
                bv+=b[i][col];
            }
            if(av%2 != bv%2){
                out.println("No");
                return;
            }
        }
        out.println("Yes");
    }
}
