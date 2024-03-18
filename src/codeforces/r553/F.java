package codeforces.r553;

import chelper.io.FastScanner;
import common.IntegerUtils;
import common.MatrixUtils;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;

public class F {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        int[] p = in.na(n);
        long mod = (int)1e9+7;

        long cnt0 = 0, cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if(p[i] == 1)
                cnt1++;
            else
                cnt0++;
        }

        if(cnt0 == 0 || cnt1 == 0){
            out.println(1);
            return;
        }
        long N = (cnt0+cnt1)*(cnt0+cnt1-1)/2%mod;

        long[][] matrix = new long[(int)cnt0+1][(int)cnt0+1]; // m[i][j] - moving from state j to state i
        long pSame = (cnt0*(cnt0-1)/2 + cnt1*(cnt1-1)/2)%mod; // exchange withing groups
        int from = Math.max(0, (int)(cnt0-cnt1));
        for (int i = from; i <= cnt0; i++) { // i - amount of 0 in first group
            matrix[i][i] = ((cnt0-i)*(cnt1-cnt0+2*i)%mod + pSame)%mod;//between groups but same numbers
            if(i < cnt0){
                matrix[i+1][i] = (cnt0-i)*(cnt0-i)%mod; // increasing amount of 0s, cnt0-i number of 0s in second group and 1s in first
            }
            if(i > from){
                matrix[i-1][i] = i*(cnt1-cnt0+i)%mod; // decreasing amount of 0s
            }
        }
//        for (int i = 0; i <= cnt0; i++) {
//            System.out.println(Arrays.toString(matrix[i]));
//        }
        int a0 = 0;
        for (int i = 0; i < cnt0; i++) {
            if(p[i] == 0)
                a0++;
        }
        long[] start = new long[(int)cnt0+1];
        start[a0] = 1; // initial state

        long[][] mPow = MatrixUtils.binPow(matrix, k, mod);
        long[] res = new long[(int)cnt0+1];
        MatrixUtils.multiply(mPow, start, res, mod);

        long invNK = IntegerUtils.pow(N, mod-1-k, mod);
        out.println(res[(int)cnt0]*invNK%mod);


    }
}
