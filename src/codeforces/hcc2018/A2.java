package codeforces.hcc2018;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Random;

public class A2 {
    long mod;

    long p = 43;
    BigInteger P = BigInteger.valueOf(p);
    long q = 31;
    BigInteger Q = BigInteger.valueOf(q);
    long[] ppows;
    long[] qpows;
    long[] pinvs;
    long[] qinvs;

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        String [] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ns();
        }
        String [] b = new String[m];
        for (int i = 0; i < m; i++) {
            b[i] = in.ns();
        }
        mod = BigInteger.probablePrime(30, new Random()).longValue();
        BigInteger MOD = BigInteger.valueOf(mod);
        ppows = new long[n+1];
        qpows = new long[m+1];
        pinvs = new long[n+1];
        qinvs = new long[m+1];
        long ppow = 1;
        long pinv = 1;
        long inv = P.modPow(MOD.subtract(BigInteger.valueOf(2)), MOD).longValue();
        for (int i = 0; i <= n; i++) {
            ppows[i] = ppow;
            pinvs[i] = pinv;
            ppow = ppow*p%mod;
            pinv = pinv*inv%mod;
        }
        long qpow = 1;
        long qinv = 1;
        inv = Q.modPow(MOD.subtract(BigInteger.valueOf(2)), MOD).longValue();
        for (int i = 0; i <= m; i++) {
            qpows[i] = qpow;
            qinvs[i] = qinv;
            qpow = qpow*q%mod;
            qinv = qinv*inv%mod;
        }
        long[] bhash = new long[n];
        long[] bsum = new long[n];
        for (int col = 0; col < m; col++) {
            for (int row = 0; row < m; row++) {
                int d = b[row].charAt(col) - 'a' + 1;
                bsum[col] = (bsum[col] + d*qpows[row])%mod;
            }
            bhash[0] = (bhash[0] + bsum[col]*ppows[col])%mod;
        }
        for (int col = m; col < n; col++) {
            for (int row = 0; row < m; row++) {
                int d = b[row].charAt(col) - 'a' + 1;
                bsum[col] = (bsum[col] + d*qpows[row])%mod;
            }
            bhash[col-m+1] = (((bhash[col-m] - bsum[col-m] + mod)%mod)*pinvs[1]%mod + bsum[col]*ppows[m-1]%mod)%mod;
        }
        long[] ahash = new long[n];
        long[] asum = new long[n];
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < m; col++) {
                int d = a[row].charAt(col) - 'a' + 1;
                asum[row] = (asum[row] + d*ppows[col])%mod;
            }
            ahash[0] = (ahash[0] + asum[row]*qpows[row])%mod;
        }
        for (int row = m; row < n; row++) {
            for (int col = 0; col < m; col++) {
                int d = a[row].charAt(col) - 'a' + 1;
                asum[row] = (asum[row] + d*ppows[col])%mod;
            }
            ahash[row-m+1] = (((ahash[row-m] - asum[row-m] + mod)%mod)*qinvs[1]%mod + asum[row]*qpows[m-1]%mod)%mod;
        }
        for (int i = 0; i <=n-m; i++) {
            for (int j = 0; j <=n-m; j++) {
                if(ahash[i] == bhash[j]){
                    boolean eq = true;
                    for (int k = 0; k < m && eq; k++) {
                        for (int l = 0; l < m; l++) {
                            if(a[i+k].charAt(l) != b[k].charAt(j+l)){
                                eq = false;
                                break;
                            }
                        }
                    }
                    if(eq){
                        out.printf("%d %d%n", i+1, j+1);
                        return;
                    }
                }

            }
        }

    }
}
