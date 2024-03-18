package codeforces.ecr33;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.ArrayList;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int MAX = 1_000_100;
        long mod = (int)1e9+7;
        long[] invs = IntegerUtils.invs(MAX, mod);
        long[] fact = new long[MAX];
        long[] invFact = new long[MAX];
        long[] pow2 = new long[MAX];
        pow2[0] = fact[0] = invFact[0] = fact[1] = invFact[1] = 1;
        pow2[1] = 2;
        for (int i = 2; i < MAX; i++) {
           fact[i] = i*fact[i-1]%mod;
           invFact[i] = invFact[i-1]*invs[i]%mod;
           pow2[i] = pow2[i-1]*2%mod;
        }


        int[][] divs = new int[MAX][8];
        int[][] divCnts = new int[MAX][8];
        int[] cnts = new int[MAX];
        ArrayList<Integer> primes = new ArrayList<>(MAX);
        int[] lp = new int[MAX+1];
        IntegerUtils.sieve(MAX, primes, lp);
        for (int i = 2; i < MAX; i++) {
            int num = i;
            while(num > 1){
                int p = lp[num];
                divs[i][cnts[i]++] = p;
                while(lp[num] == p) {
                    divCnts[i][cnts[i]-1]++;
                    num /= p;
                }
            }
        }
        int q = in.ni();
        for (int i = 0; i < q; i++) {
            int x = in.ni(), y = in.ni();
            long ans = 1;
            if(x != 1 && y != 1) {
                for (int j = 0; j < cnts[x]; j++) {
                    if (divCnts[x][j] == 1) {
                        ans = ans * y % mod;
                    } else {
                        ans = ans * fact[divCnts[x][j] + y - 1] % mod * invFact[y - 1] % mod * invFact[divCnts[x][j]] % mod;
                    }
                }
            }
            ans = ans*pow2[y-1]%mod;
            out.println(ans);
        }

    }
}
