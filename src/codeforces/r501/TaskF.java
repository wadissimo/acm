package codeforces.r501;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;

public class TaskF {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long mod = 1000000007L;
        int n = in.ni()*2;
        String s = in.ns();
        long[][] C = IntegerUtils.pascal_triangle_modulo(207, mod);
        int bal = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ')')
                bal--;
            else
                bal++;
        }

        long[][] dop = new long[n+1][n+1];
        dop[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                //(
                if(j > 0)
                    dop[i][j] += dop[i-1][j-1];
                //)
                if(j < i)
                    dop[i][j] += dop[i-1][j+1];
                dop[i][j] %= mod;
            }
        }
        System.out.println((C[200][100]-C[200][99]+mod)%mod);
        System.out.println(dop[200][0]);
    }
}
