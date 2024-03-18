package codeforces.r491;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.HashSet;

public class TaskE {
    long[][] C = IntegerUtils.pascal_triangle(20);
    int []digs = new int[10];
    long ans = 0;
    void iterDig(int i, int di[]){
        if(i == 10){
            int cnt = 0;
            for (int j = 0; j < 10; j++) {
                cnt+=di[j];
            }
            if(di[0] == cnt)return;
            long res = 1;
            for (int j = 0; j < 10; j++) {
                if(di[j] != 0 && di[j] < cnt) {
                    if(j == 0){
                        res *= C[cnt-1][di[j]];
                    } else {
                        res *= C[cnt][di[j]];
                    }
                    cnt -= di[j];
                }
            }
            ans += res;
        } else {
            if (digs[i] == 0) {
                iterDig(i+1, di);
            } else {
                for (int j = 1; j <= digs[i]; j++) {
                    di[i] = j;
                    for (int k = i+1; k < 10; k++) {
                        di[k] = 0;
                    }
                    iterDig(i+1, di);
                }
            }
        }

    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.nl();

        String s = Long.toString(n);
        for (int i = 0; i < s.length(); i++) {
            digs[s.charAt(i)-'0'] += 1;
        }
        iterDig(0, new int[10]);
        out.println(ans);

    }
}
