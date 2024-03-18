package SPOJ;

import chelper.io.InputReader;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class GONE {
    static int[][] d;
    static HashSet<Integer> primes = new HashSet<>();
    static int f(int k, int prefix){ // k-dig length
        if(k == 0){
            if(primes.contains(prefix))
                return 1;
            else
                return 0;
        }
        int res = 0;
        for (int i = 0; i < k * 9 + 1; i++) {
             if(primes.contains(i+prefix)){
                 res += d[k-1][i];
             }
        }
        return res;
    }
    static int calc(int n){
        String s = String.valueOf(n);
        int len = s.length();
        int prefix = 0;
        int res = 0;
        for (int i = 0; i < len; i++) {
            int x = s.charAt(i)-'0';
            for (int j = 0; j < x; j++) {
                res += f(len-i-1, prefix+j);
            }
            prefix += x;
        }
        return res;
    }
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        d = new int[8][90];
        for (int i = 0; i < 10; i++) {
            d[0][i] = 1;
        }
        for (int i = 1; i < 8; i++) {
            for (int j = 0; j < i * 9 + 1; j++) {
                int cnt = d[i-1][j];
                for (int k = 0; k < 10; k++) {
                    d[i][j+k] += cnt;
                }
            }
        }
        int[] lp = new int[73];
        ArrayList<Integer> pr = new ArrayList<>();
        IntegerUtils.sieve(72, pr, lp);
        primes.addAll(pr);

        int C = in.ni();
        for (int c = 0; c < C; c++) {
            int f = in.ni();
            int t = in.ni();
            if(f>t)
                out.println(0);
            else{
                if(f == 0)
                    f ++;
                out.println(calc(t+1)-calc(f));
            }

        }
    }
}
