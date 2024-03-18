package main;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;

public class TaskB {
    boolean check(int[] a){
        return a[0]+a[1]+a[2] == a[3]+a[4]+a[5];
    }
    int[] toDigitArray(int a){
        int size = 0;
        int num = a;
        while(num > 0){
            num/=10;
            size++;
        }
        int[] digs = new int[size];
        int idx = 0;
        while(a > 0){
            digs[idx++] = a%10;
            a/=10;
        }
        return digs;
    }
    int[] toDigitArray6(int a){
        int[] digs = new int[6];
        int idx = 0;
        while(a > 0){
            digs[idx++] = a%10;
            a/=10;
        }
        return digs;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        int[] target = new int[6];
        for (int i = 5; i >= 0; i--) {
            target[i] = s.charAt(i)-'0';
        }
        int best = 6;
        for (int i = 0; i < 1_000_000; i++) {
            int[] digs = toDigitArray6(i);
            if(check(digs)){
                int cnt = 0;
                for (int j = 0; j < 6; j++) {
                    if(digs[j] != target[j])
                        cnt++;
                }
                best = Math.min(best, cnt);
            }
        }
        out.println(best);
    }
}
