package codeforces.r443;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class C {
    int[][] bits;

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        char[] op = new char[n];
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            op[i] = in.ns().charAt(0);
            x[i] = in.ni();
        }
        int[] nums = new int[]{0, 1023};

        bits = new int[2][10];
        for (int l = 0; l < 2; l++) {
            int num = nums[l];
            for (int i = 0; i < n; i++) {
                if(op[i] == '&'){
                    num &= x[i];
                } else if(op[i] == '|'){
                    num |= x[i];
                } else if(op[i] == '^'){
                    num ^= x[i];
                }
            }
            for (int j = 0; j < 10; j++) {
                if((num&(1<<j)) > 0)
                    bits[l][j] = 1;
            }
        }
//       System.out.println("Arrays.toString(bits[0]) = " + Arrays.toString(bits[0]));
//        System.out.println("Arrays.toString(bits[1]) = " + Arrays.toString(bits[1]));

        int xAnd = 1023;
        int xXor = 0;
        int xOr = 0;
        for (int i = 0; i < 10; i++) {
            if(bits[1][i] == 1 && bits[0][i] == 1){
                xOr |= (1<<i);
            } else if(bits[1][i] == 0 && bits[0][i] == 0) {
                xAnd ^= (1<<i);
            } else if(bits[1][i] == 0 && bits[0][i] == 1){
                xXor ^= (1<<i);
            }
        }
        out.println(3);
        out.println("& " + xAnd);
        out.println("| " + xOr);
        out.println("^ " + xXor);

    }
}
