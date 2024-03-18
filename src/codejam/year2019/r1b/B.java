package codejam.year2019.r1b;

import chelper.io.FastScanner;
import common.MatrixUtils;

import java.io.PrintWriter;
import java.util.Arrays;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {

        long mod = (int)1e9+7;//todo:
        int T = in.ni(), W = in.ni();
        for (int t = 0; t < T; t++) {
            if(W == 6) {
                long[][] matrix = new long[][]{{2, 1, 1, 1, 1, 1, 0}, {4, 2, 1, 1, 1, 1, 0}, {8, 2, 2, 1, 1, 1, 0}, {16, 4, 2, 2, 1, 1, 0}, {32, 4, 2, 2, 2, 1, 0}, {64, 8, 4, 2, 2, 2, 0}};
                int[] res = new int[W];
                for (int i = 0; i < W; i++) {
                    out.println(i + 1);
                    out.flush();
                    res[i] = in.ni();
                    matrix[i][6] = res[i];
                }
                long[] ans = new long[W];
                MatrixUtils.gaussMod(matrix, ans, mod);

                for (int i = 0; i < W; i++) {
                    out.print(ans[i] + " ");
                }
                out.println();
                out.flush();
                int response = in.ni();
                if (response == -1)
                    return;
            } else if(W == 2){
                out.println(224);
                out.flush();
                long res = in.nl(); // 56 44 37
                long r6 = (res % (1L<<44))>>>37;
                res -=  (res % (1L<<44));
                long r5 = (res % (1L<<56))>>>44;
                long r4 = (res - (res % (1L<<56))) >>>56;
                out.println(56);//56 28 18 14 11 9
                out.flush();
                res = in.nl();
                res -= (1L<<9)*r6 + (1L<<11)*r5 + (1L<<14)*r4;
                long r3 = (res %(1L << 28)) >>>18;
                res -= (res %(1L << 28));
                long r2 = (res %(1L << 56)) >>>28;
                res-= (res %(1L << 56));
                long r1 = res >>> 56;
                out.println(r1 + " " + r2 + " " + r3 + " " + r4 + " " + r5 + " " + r6);
                out.flush();
                int response = in.ni();
                if (response == -1)
                    return;
            }
        }

    }
}
