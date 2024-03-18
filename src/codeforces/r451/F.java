package codeforces.r451;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;

public class F {
    String s;
    long p = 10;
    long[] hash;
    long[] pows;
    int[] digs;
    long mod;
    int n;
    boolean check(int aSize, int bSize, int cSize){
//        if(aSize == 0 || digs[n-cSize] == 0 || digs[aSize] == 0)
        if(aSize == 0)
            return false;
        long ch = (hash[n]-hash[n-cSize]*pows[cSize]%mod + mod)%mod;
        long bh = (hash[n-cSize]-hash[aSize]*pows[bSize]%mod + mod)%mod;
        long ah = hash[aSize];
        if((ah + bh)%mod == ch){
            return true;
        } else
            return false;
    }
    String getAns(int aSize, int bSize, int cSize){
        return s.substring(0, aSize) + "+" + s.substring(aSize, aSize+bSize) + "=" + s.substring(n-cSize, n);
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {

        s = in.ns();

        n = s.length();

        digs = new int[n];
        for (int i = 0; i < n; i++) {
            digs[i] = s.charAt(i)-'0';
        }

        mod = BigInteger.probablePrime(30, new Random()).longValue();

        hash = new long[n+1];
        long[] invs = new long[n];

        pows = new long[n+1];
        pows[0] = 1;
        for (int i = 0; i < n; i++) {
            hash[i+1] = (hash[i]*p + digs[i])%mod;
            pows[i+1] = pows[i]*p%mod;
        }
        for (int i = n/3; i <= n/2 ; i++) {
            if(check(n-i-i, i, i)){
                out.println(getAns(n-i-i, i, i));
                return;
            }
            if(check(i, n-i-i, i)){
                out.println(getAns(i, n-i-i, i));
                return;
            }
            if(check(n-i-i+1, i-1, i)){
                out.println(getAns(n-i-i+1, i-1, i));
                return;
            }
            if(check(i-1, n-i-i+1, i)){
                out.println(getAns(i-1, n-i-i+1, i));
                return;
            }
        }

    }
}
