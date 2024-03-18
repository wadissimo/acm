package main;

import chelper.io.FastScanner;
import common.MatrixUtils;

import java.io.PrintWriter;

public class SquareFreeNumber {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        long[][] matrix = new long[9][9];
        for (int i = 1; i <= 9; i++) {
            for (int j = 1; j <= 9; j++) {
                if(i+j != 4 && i+j != 9 && i+j != 16){
                    matrix[i-1][j-1] = 1;
                }
            }
        }
        long mod = (int)1e9 + 7;
        for (int t = 0; t < T; t++) {
            long n = in.nl();
            if(n == 1){
                out.println(6);
            } else {
                long[] v = {1,1,1,1,1,1,1,1,1};
                long[][] pow = MatrixUtils.binPow(matrix, n - 1, mod);
                long[] res = new long[9];
                MatrixUtils.multiply(pow, v, res, mod);
                long sum = 0;
                for (int i = 0; i < 9; i++) {
                    sum += res[i];
                }
                out.println(sum%mod);
            }
        }
    }
}
