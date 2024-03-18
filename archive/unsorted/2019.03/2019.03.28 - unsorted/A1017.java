package timus;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A1017 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        long [][] dp = new long[n+1][n+1];
//        long [][] prev = new long[n+1][n+1];
        dp[0][n] = 1;
        long ans = 0;
        int used = 0;
        for (int i = 1; i*(i+1)/2 <=n ; i++) {
//            System.out.println("i = " + i);
//            System.out.println("(i*(i+1)) = " + (i * (i + 1)));
//            System.out.println("ans = " + ans);
            for (int j = n/2; j >=i-1; j--) {
                for (int rem = j+1; rem <=n; rem++) {
                    ans += dp[j][rem];
                    for (int k = j+1; 2*k+1 <= rem; k++) {
                        dp[k][rem-k] += dp[j][rem];
                    }
                    dp[j][rem] = 0;
                }
            }
            used+= i;
        }

        out.println(ans-1);


    }
}
