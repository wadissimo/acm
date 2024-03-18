package main;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;

public class EXORPartitioning {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni();
        int[] a = in.na(N);
        int[] pref = new int[N+1];
        for (int i = 0; i < N; i++) {
            pref[i+1] = pref[i]^a[i];
        }
        long mod = (int) 1e9 + 7;
        int s = pref[N];
        if(s != 0) {
            long dp0 = 1;
            long dpS = 0;
            for (int i = 0; i <= N; i++) {
                if (pref[i] == 0) {
                    dp0 = (dp0 + dpS) % mod;
                } else if (pref[i] == s) {
                    dpS = (dpS + dp0) % mod;
                }
            }
            out.println(dp0);
        } else {
            int MAX = 1<<20;
            int[] cnt0 = new int[N+1];
            for (int i = 0; i < N; i++) {
                cnt0[i+1] = cnt0[i] + (pref[i+1]==0?1:0);
            }
            int[] idx = new int[MAX+1];
            Arrays.fill(idx, -1);
            long [] dps = new long[MAX+1];
            long [] dp0 = new long[MAX+1];
            Arrays.fill(dp0, 1);
            int tot0 = 0;
            for (int i = 1; i < N; i++) {
                int p = pref[i];
                if(p == 0){
                    tot0++;
                    continue;
                }
                if(idx[p] == -1){
                    dps[p] = 1;
                } else {
                    dp0[p] = (dp0[p] + dps[p]*(cnt0[i]-cnt0[idx[p]]))%mod;
                    dps[p] = (dps[p] + dp0[p])%mod;
                }
                idx[p] = i;
            }
            long ans = 0;
            if(tot0 > 0){
                ans = (IntegerUtils.pow(2, tot0, mod) + mod-1)%mod;
            }
            for (int i = 0; i <= MAX; i++) {
                if(dps[i] > 0){
                    ans = (ans + dps[i])%mod;
                }
            }
            out.println((ans+1)%mod);
        }
//        System.out.println("Arrays.toString(pref) = " + Arrays.toString(pref));



    }
}
