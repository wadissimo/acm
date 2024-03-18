package main;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.Arrays;

public class DPalindromniiXOR {
    long mod = 998244353;
    int N;
    int[] tgt;
    long ans = 0;
    int[] a;
    int[] b;
    long calc(int len){
        System.out.println("len = " + len);
        Arrays.fill(a, -1);
        Arrays.fill(b, -1);
        for (int i = 0; i < N - len; i++) {
            b[i] = 0;
        }
        long res = 0;
        for (int i = 0; i < N - len; i++) { // first chars are equal to tgt
            if(a[i] == -1){
                int updates = update(a, b, N, len, i);
                if(updates == -1)
                    return 0;
                res+= updates;
            }
        }
        return IntegerUtils.pow(2, res, mod);
    }
    int update(int[] first, int[] second, int firstLen, int secondLen, int idx){
        if(first[idx] != -1)
            return 0;//end
        int res = tgt[idx] == 2?1:0;
        if(second[idx] == 2 || tgt[idx] == 2)
            first[idx] = 2;
        else
            first[idx] = second[idx]^tgt[idx];
        int lastIdx = firstLen-1-idx;
        if(firstLen < N){
            lastIdx = N-1-idx+N-firstLen;
        }
        if(idx == lastIdx){
            if(second[idx] == 2)
                return tgt[lastIdx] == 2?2:1;
            else {
                return tgt[lastIdx] == 2?1:0;
            }
        }
        first[lastIdx] = first[idx];
        if(second[lastIdx] == -1){
            int next = update(second, first, secondLen, firstLen, lastIdx);
            if(next == -1)
                return -1;
            return next+res;
        } else {
            if(second[lastIdx] != 0)
                throw new RuntimeException();
            if(tgt[lastIdx] != 2 && first[lastIdx] != 2 && first[lastIdx] != tgt[lastIdx])
                return -1;
            return tgt[lastIdx] == 2 ? 1:0;
        }
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        N = s.length();
        tgt = new int[N];
        a = new int[N];
        b = new int[N];
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if(c == '1')
                tgt[i] = 1;
            else if(c == '?')
                tgt[i] = 2;
        }
        if(tgt[N-1] == 1 || N == 1){
            out.println(0);
            return;
        }
        for(int len = N-1; len > 0; len--){
            long calc = calc(len);
            System.out.println("calc = " + calc);
            ans = (ans+ calc)%mod;
        }
        out.println(ans);
    }
}
