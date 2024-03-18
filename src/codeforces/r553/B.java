package codeforces.r553;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        int[][] a = new int[n][];
        for (int i = 0; i < n; i++) {
            a[i] = in.na(m);
        }
        int res = 0;
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            res ^= a[i][0];
        }
        if(res != 0){
            out.println("TAK");
            for (int i = 0; i < n; i++) {
                out.print("1 ");
            }
            out.println();
        } else {
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if(a[i][j] != a[i][0]){
                        out.println("TAK");
                        for (int k = 0; k < n; k++) {
                            if(k == i){
                                out.print((j+1) + " ");
                            } else {
                                out.print("1 ");
                            }
                        }
                        out.println();
                        return;
                    }
                }
            }
            out.println("NIE");
        }

    }
}
