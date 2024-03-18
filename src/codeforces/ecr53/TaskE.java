package codeforces.ecr53;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.math.BigInteger;

public class TaskE {
    long [][]dsum = new long[19][1024];
    long [][]dcnt = new long[19][1024];
    long []ssum = new long[19];
    long []scnt = new long[19];
    long mod = 998244353;
    int[] nbits = new int[1024];
    long []p10 = new long[19];
    int k;

    long getSum(int len){
        long res = 0;
        for (int i = 1; i <= len; i++) {
            res += ssum[i];
            res %= mod;
        }
        return res%mod;
    }
    long getSum(int prefixMask, int len){
        if(len == 0)
            return 0;
        long res = 0;
        for (int mask = 1; mask < 1024; mask++) {
            if(nbits[mask|prefixMask] <= k){
                res += dsum[len][mask];
                res %= mod;
            }
        }
        return res%mod;
    }
    long getCnt(int prefixMask, int len){
        if(nbits[prefixMask] > k)
            return 0;
        if(len ==0)
            return 1;
        long res = 0;
        for (int mask = 1; mask < 1024; mask++) {
            if(nbits[mask|prefixMask] <= k){
                res += dcnt[len][mask];
                res %= mod;
            }
        }
        return res%mod;
    }
    long getCnt(int len){
        long res = 0;
        for (int i = 1; i <= len; i++) {
            res += scnt[i];
            res %= mod;
        }
        return res%mod;
    }


    long calc(long num){
        String s = Long.toString(num);
        int len = s.length()-1;
        long res = 0;
        int prefixMask = 0;
        long prefix = 0;
        for (int i = 0; i < s.length(); i++) {
            int d = s.charAt(i)- '0';
            prefix *= 10;
            for (int x = 0; x < d; x++) {
                int mask = prefixMask | 1 << x;
                long curPrefix = prefix + x;
                if(i == 0 && x == 0)
                    res += getSum(len);
                else
                    res += curPrefix*p10[len]%mod*getCnt(mask, len)%mod + getSum(mask, len);
                res %= mod;
            }
            prefix += d;
            prefixMask |= 1<<d;
            len--;
        }
        return res;
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long l = in.nl(); long r = in.nl(); k = in.ni();

        p10[0] = 1;
        for (int i = 1; i <= 18; i++) {
            p10[i] = p10[i-1]*10 % mod;
        }

        for (int i = 0; i < 1024; i++) {
            nbits[i] = Integer.bitCount(i);
        }

        for (int i = 0; i < 10; i++) {
            dsum[1][1<<i] = i;
            dcnt[1][1<<i] = 1;
        };
        scnt[1] = 9;
        ssum[1] = 45;
        for (int len = 2; len < 19; len++) {
            for (int d = 0; d <=9; d++) {
                int bit = 1<<d;
                for (int mask = 1; mask < 1024; mask++){
                    int newMask = mask|bit;
                    if(nbits[newMask]<=k){
                        dcnt[len][newMask] += dcnt[len-1][mask];
                        long subsum = d * p10[len - 1] * dcnt[len - 1][mask] + dsum[len - 1][mask];
                        dsum[len][newMask] += subsum;
                        dcnt[len][newMask] %= mod;
                        dsum[len][newMask] %= mod;
                        if(d != 0){
                            scnt[len] += dcnt[len-1][mask];
                            ssum[len] += subsum;
                            scnt[len] %= mod;
                            ssum[len] %= mod;
                        }
                    }
                }
            }


        }

        out.println((calc(r+1) -calc(l)+mod)%mod);
    }
}
