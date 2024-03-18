package codeforces.ecr63;

import chelper.io.FastScanner;
import common.IntegerUtils;
import common.MatrixUtils;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

import static java.lang.Math.abs;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long mod = 1_000_003;
//        long[][] testMatrix = {{-1,2,3}, {4,-2,8}, {2,1,8}};
//        long[][] aa = {{2,1,-1,8}, {-3,-1,2, -11}, {-2,1,2, -3}, {1,1,1,4}};
//        long[] ans2 = new long[3];
//        gaussMod(aa, ans2, mod);
//        System.out.println("Arrays.toString(ans) = " + Arrays.toString(ans2));
//        if(true)
//            return;
        out.println("? 0");
        out.flush();
        int a0 = in.ni();
        if(a0 == -1)
            return;
        if(a0 == 0){
            out.println("! 0");
            out.flush();
            return;
        }
        int MAX = 30;
        long[][] matrix = new long[MAX][12];
        Random rand = new Random();
        for (int i = 0; i < MAX-1; i++) {
            long x = rand.nextInt(100_000);
            out.println("? " + x);
            out.flush();
            long res = in.ni();
            if(res == -1)
                return;
            res = (res+mod-a0)%mod;
            long cur = x;
            for (int j = 0; j < 11; j++) {
                matrix[i][j] = cur%mod;
                cur = cur*x%mod;
            }
            matrix[i][11] = res;
        }
        long[] ans = new long[11];
        long[] invs = IntegerUtils.invs((int)mod + 1, mod);
        MatrixUtils.gaussMod(matrix, ans, mod, invs);

//        long[] ans = {0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0};
//        System.out.println("ans = " + Arrays.toString(ans));
        for (int x = 1; x < mod ; x++) {
            long cur = a0;
            long res = x;
            for (int i = 0; i < 11; i++) {
                cur = (cur +ans[i]*res)%mod;
                res = res*x%mod;
            }
            if(cur%mod == 0){
                out.println("! " + x);
                out.flush();
                return;
            }
        }
        out.println("! -1");
        out.flush();

    }
//    public static void main(String[] args) {
//
//        //matrix
//        double[][] testMatrix = {{-1,2,3}, {4,-2,8}, {2,1,8}};
//
//        //print matrix and # of columns to console
//        printMatrix(testMatrix);
//        System.out.println("matrix.length = " + testMatrix.length);
//        System.out.println("------------------");
//
//        //gauss partial pivot
//        double[][] answer = gaussPartialPivot(testMatrix);
//        printMatrix(answer);
//
//    }




}
