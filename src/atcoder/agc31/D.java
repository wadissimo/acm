package atcoder.agc31;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;
import java.util.Arrays;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        int[] p = new int[n];
        int[] q = new int[n];

        for (int i = 0; i < n; i++) {
            p[i] = i;
            q[i] = i;
        }
        ArrayUtils.randomShuffle(p);
        ArrayUtils.randomShuffle(q);

        int max = 5000;
        int[][]res = new int[max][n];
        res[0] = p;
        res[1] = q;
        for (int i = 2; i < max; i++) {
            for (int j = 0; j < n; j++) {
                res[i][res[i-2][j]] = res[i-1][j];
            }
        }

        for (int i = max-2; i >=0; i--) {
            boolean eq = true;
            for (int j = 0; j < n; j++) {
                if(res[max-1][j] != res[i][j]){
                    eq = false;
                    break;
                }
            }
            if(eq){
                System.out.println("(max-i) = " + (max-1 - i));
                break;
            }
        }

    }
}
