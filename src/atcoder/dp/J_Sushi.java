package atcoder.dp;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class J_Sushi {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int[] c = new int[4];
        int total = 0;
        for (int i = 0; i < n; i++) {
            c[a[i]]++;
            total += a[i];
        }
        double[][][] dp = new double[c[3]+3][c[3]+c[2]+3][total+3];
        double nd = n;
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                for (int k = 0; k < dp[i][j].length; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        dp[c[3]][c[2]][c[1]] = 0;
        for (int k3 = c[3]; k3 >= 0 ; k3--) {
            for (int k2 = total-c[3]; k2 >= 0 ; k2--) {
                for (int k1 = total-c[3]-c[2]; k1 >= 0 ; k1--) {
                    if(dp[k3][k2][k1] == -1)
                        continue;
                    System.out.print("k3 = " + k3);
                    System.out.print(" k2 = " + k2);
                    System.out.println(" k1 = " + k1);
                    System.out.println("dp[k3][k2][k1] = " + dp[k3][k2][k1]);

                    dp[k3][k2][k1] = 0;
                    if(k3 > 0 && dp[k3-1][k2+1][k1] != -1) {
                        dp[k3][k2][k1] += (dp[k3+1][k2-1][k1]+1)*n/k3;
                    }
                    if(k3 > 0){
                        dp[k3-1][k2+1][k1] += (dp[k3][k2][k1] + 1)*k3/nd;
                        System.out.println("dp[k3-1][k2+1][k1] = " + dp[k3 - 1][k2 + 1][k1]);
                    }
                    if(k2 > 0){
                        dp[k3][k2-1][k1+1] += (dp[k3][k2][k1] + 1)*k2/nd;
                    }
                    if(k1 > 0){
                        dp[k3][k2][k1-1] += (dp[k3][k2][k1] + 1)*k1/nd;
                    }
                }
            }
        }
        out.println(dp[0][0][0]);
    }
}
