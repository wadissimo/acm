package SPOJ;

import chelper.io.InputReader;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.math.BigDecimal;
import java.math.BigInteger;

import static java.lang.Math.max;

public class NUMTSN {
    static long [][][][]d;
    static long mod = 1000000007L;
    static long f(int k, int pref3, int pref6, int pref9){
        if(k == 0){
            return (pref3>0 && pref3 == pref6 && pref3 == pref9) ? 1:0;
        }
        if(pref3 > 16 || pref6 >16 || pref9 > 16)
            return 0;
        long res = 0;


        for (int i = max(max(1,pref3), max(pref6,pref9)); i <= 16; i++) {
            res += d[k][i - pref3][i - pref6][i - pref9];
        }
        return res%mod;
    }
    static long calc(String s){
        long res = 0;
        int pref3=0,pref6=0,pref9 = 0;
        int len = s.length();
        for (int i = 0; i < len; i++) {
            int x = s.charAt(i)-'0';
            for (int j = 0; j < x; j++) {
                if(j==3)
                    res+= f(len-i-1, pref3+1, pref6, pref9);
                else if(j==6)
                    res+= f(len-i-1, pref3, pref6+1, pref9);
               // else if(j==9)
                //    res+= f(len-i-1, pref3, pref6, pref9+1);
                else
                    res += f(len-i-1, pref3, pref6, pref9);
            }
            if(x==3)
                pref3++;
            else if(x==6)
                pref6++;
            else if(x==9)
                pref9++;
        }
        return res%mod;
    }



    public void solve(int testNumber, InputReader in, PrintWriter out) {
        d = new long[51][17][17][17];
        d[1][0][0][0] = 7;
        d[1][1][0][0] = d[1][0][1][0] = d[1][0][0][1] = 1;
        for (int i = 2; i <= 50; i++) {
            int lim = 16;
            for (int j = 0; j <= lim; j++) {
                for (int k = 0; k <= lim; k++) {
                    for (int l = 0; l <= lim; l++) {
                        d[i][j][k][l] = d[i-1][j][k][l]*7;
                        if(j>0)
                            d[i][j][k][l] += d[i-1][j-1][k][l];
                        if(k>0)
                            d[i][j][k][l] += d[i-1][j][k-1][l];
                        if(l>0)
                            d[i][j][k][l] += d[i-1][j][k][l-1];
                        d[i][j][k][l] %= mod;
                    }
                }
            }

        }
        /*long[][] Cb = IntegerUtils.pascal_triangle(51);
        long [][][][] dx = new long[51][18][18][18];
        for (int i = 1; i <= 50; i++) {
            for (int j = 0; j <= 16; j++) {
                for (int k = 0; k <= 16; k++) {
                    for (int l = 0; l <= 16; l++) {
                        if(j+k+l<=i){
                            long n3 = j>0?Cb[i][j]%mod:1;
                            long n6 = k>0?Cb[i-j][k]%mod:1;
                            long n9 = l>0?Cb[i-j-k][l]%mod:1;
                            long rest = BigInteger.valueOf(7).modPow(BigInteger.valueOf(i-j-k-l), BigInteger.valueOf(mod))
                                    .longValue();
                            dx[i][j][k][l] = (((((n3*n6)%mod)*n9)%mod)*rest)%mod;
                            if(dx[i][j][k][l] != d[i][j][k][l]){
                                throw new RuntimeException("failed");
                            }
                        }
                    }
                }
            }

        }*/

        int C = in.ni();
        for (int c = 0; c < C; c++) {
            String f = in.ns();
            String t = in.ns();
            long ans = 0;
            int n3=0,n6=0,n9=0;
            for (int i = 0; i < t.length(); i++) {
                if(t.charAt(i) == '3')
                    n3++;
                else if(t.charAt(i) == '6')
                    n6++;
                else if(t.charAt(i) == '9')
                    n9++;
            }
            if(n3 > 0 && n3==n6 && n3==n9)
                ans ++;
            BigInteger fb=new BigInteger(f);
            BigInteger tb = new BigInteger(t);
            if(!fb.equals(tb))
                ans = (ans + calc(t)-calc(f))%mod;
            out.println(ans%mod);
        }
    }
}
