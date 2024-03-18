package main;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class TaskB {
    int read(FastScanner in, PrintWriter out, int i, int j){
        out.printf("? %d %d", i, j);
        out.flush();
        return in.ni();
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int[] res = new int[6];
        int[] mult = new int[4];
        for (int i = 0; i < 4; i++) {
            mult[i] = read(in, out, 1, i+2);
        }
        int gcd = mult[0];
        for (int i = 0; i < 4; i++) {
            gcd = (int)IntegerUtils.gcd(gcd, mult[i]);
        }
        HashSet<Integer> set = new HashSet<>();
        res[0] = gcd;
        set.add(gcd);
        for (int i = 0; i < 4; i++) {
            res[i+1] = mult[i]/gcd;
            set.add(res[i+1]);
        }
        int[] needed = {4 , 8, 15, 16, 23, 42};
        for (int i = 0; i < 6; i++) {
            if(!set.contains(needed[i])){
                res[5] = needed[i];
                break;
            }
        }
        out.print("! ");
        for (int i = 0; i < 6; i++) {
            out.print(res[i] + " ");
        }
        out.println();
        out.flush();



    }
}
