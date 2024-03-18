package codejam.year2008.r1c;

import chelper.io.FastScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class B {

    private static long count(String s, int div) {
        int n = s.length();
        int[][] vals = new int[n+1][n+1];
        for (int i = 0; i < n; i++) {
            int num = (s.charAt(i)-'0')%div;
            vals[i][1] = num;
            for (int j = 2; j <= n-i ; j++) {
                num = (num*10 + s.charAt(i+j-1)-'0')%div;
                vals[i][j] = num;
            }
        }
        long[][] dp = new long[n+1][div];
        dp[0][0] = 1;
        for (int i = 0; i < n ; i++) {
            for (int j = 1; j <= n-i ; j++) {
                int val = vals[i][j];
                for (int k = 0; k < div; k++) {
                    dp[i+j][(k+val)%div] += dp[i][k];
                    dp[i+j][(k-val + div)%div] += dp[i][k];
                }
            }
        }
        return dp[n][0]/2;
    }
    public static void main(String[] args) throws FileNotFoundException {
//                        FastScanner in = new FastScanner(System.in);
//        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner(B.class.getResourceAsStream("B-large-practice.in"));
        PrintWriter out = new PrintWriter(new File("/home/vadim/dev/tmp/B.out"));

        int T = in.ni();
        int[] ps = new int[]{2,3,5,7};
        for (int t = 0; t < T; t++) {
            String s = in.ns();
            long ans = 0;
            for (int mask = 1; mask < 1<<4 ; mask++) {
                int num = 1;
                int sign = -1;
                for (int i = 0; i < 4; i++) {
                    if((mask&(1<<i)) != 0){
                        sign*=-1;
                        num*=ps[i];
                    }
                }
                ans += sign*count(s, num);
            }
            out.printf("Case #%d: %d%n", t+1, ans);
        }
        out.flush();
        out.close();
    }
}
