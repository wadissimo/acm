package codeforces.all;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class R259B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {

        int MAXNUM = 59;
        int[] primes = new int[16];
        int pi = 0;
        int[] masks = new int[MAXNUM];
        for (int i = 2; i < MAXNUM; i++) {
            boolean prime = true;
            for (int div = 2; div*div <= i; div++) {
                if(i%div == 0){
                    prime = false;
                    break;
                }
            }
            if(prime)
                primes[pi++] = i;
        }
        for (int i = 1; i < MAXNUM; i++) {
            int mask = 0;
            for (int j = 0; j < 16; j++) {
                if(i%primes[j] == 0){
                    mask |= 1<<j;
                }
            }
            masks[i] = mask;
            //System.out.println("i = " + i);
            //System.out.println("mask = " + Integer.toBinaryString(mask));
        }
        int n = in.ni();
        int[] a = in.na(n);
        int[][] dp = new int[n+1][1<<16];
        int[][] p = new int[n+1][1<<16];
        for (int i = 0; i < n + 1; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        int all1 = (1<<16)-1;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < MAXNUM; j++) {
                int rmask = all1 - masks[j];
                int abs = Math.abs(a[i]-j);
                for(int smask = rmask; smask >= 0;smask = (smask-1)&rmask){
                    if(dp[i][smask] != Integer.MAX_VALUE){
                        if(dp[i][smask] + abs < dp[i+1][smask|masks[j]]){
                            dp[i+1][smask|masks[j]] = dp[i][smask] + abs;
                            p[i+1][smask|masks[j]] = j;
                        }
                    }
                    if(smask == 0) break;
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        int mask = 0;
        for (int i = 0; i < 1 << 16; i++) {
            if(dp[n][i] < ans){
                ans = dp[n][i];
                mask = i;
            }
        }
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = n; i > 0 ; i--) {
            list.push(p[i][mask]);
            if(p[i][mask] != 1)
                mask ^= masks[p[i][mask]];
        }
        for(int num: list){
            out.print(num + " ");
        }
        out.println();
    }
}
