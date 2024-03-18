package codeforces.r530;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        char[][] map = in.nm(n,m);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(map[i][j] == 'A')
                    map[i][j] = 0;
                else if(map[i][j] == 'G')
                    map[i][j] = 1;
                else if(map[i][j] == 'C')
                    map[i][j] = 2;
                else if(map[i][j] == 'T')
                    map[i][j] = 3;
            }
        }
        char[] chars = new char[]{'A', 'G', 'C', 'T'};
        int[][][] dp = new int[n][m][4];
        int[][][][] row = new int[n][m][4][4];
        int[][][][] col = new int[n][m][4][4];
        int[][][][] rowp = new int[n][m][4][4];
        int[][][][] colp = new int[n][m][4][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < 4; k++) {
                    for (int l = 0; l < 4; l++) {
                        row[i][j][k][l] = col[i][j][k][l] = Integer.MAX_VALUE;
                    }
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i == 0 && j == 0){
                    for (int k = 0; k < 4; k++) {
                        if(k!=map[i][j])
                            dp[i][j][k]++;
                    }
                } else if(i == 0){
                    for (int k = 0; k < 4; k++) {
                        dp[i][j][k] = Integer.MAX_VALUE;
                        int add = (map[i][j] == k)?0:1;
                        for (int k2 = 0; k2 < 4; k2++) {
                            if(k2 != k){
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i][j-1][k2]+add);
                                row[i][j][k][k2] = Math.min(row[i][j][k][k2], dp[i][j-1][k2]+add);
                            }
                        }
                    }
                }
                else if(j == 0){
                    for (int k = 0; k < 4; k++) {
                        dp[i][j][k] = Integer.MAX_VALUE;
                        int add = (map[i][j] == k)?0:1;
                        for (int k2 = 0; k2 < 4; k2++) {
                            if(k2 != k){
                                dp[i][j][k] = Math.min(dp[i][j][k], dp[i-1][j][k2]+add);
                                col[i][j][k][k2] = Math.min(col[i][j][k][k2], dp[i-1][j][k2]+add);
                            }
                        }
                    }
                } else {
                    for (int k = 0; k < 4; k++) {
                        dp[i][j][k] = Integer.MAX_VALUE;
                        int add = (map[i][j] == k)?0:1;
                        for (int kl = 0; kl < 4; kl++) {
                            if(kl == k)
                                continue;
                            for (int ku = 0; ku < 4; ku++) {
                                if(ku == k || ku == kl)
                                    continue;
                                for (int kk = 0; kk < 4; kk++) {
                                    if(kk == k || kk == kl || kk == ku)
                                        continue;
                                    int val = row[i-1][j][ku][kk] + col[i][j-1][kl][kk] - dp[i-1][j-1][kk]+add;
                                    dp[i][j][k] = Math.min(dp[i][j][k], val);
                                    if(val < row[i][j][k][kl]){
                                        row[i][j][k][kl] = val;
                                        rowp[i][j][k][kl] = ku+4*kk;
                                    }
                                    if(val < col[i][j][k][ku]){
                                        col[i][j][k][ku] = val;
                                        colp[i][j][k][ku] = kl+4*kk;
                                    }
                                    /*System.out.print("k = " + k);
                                    System.out.print(" kl = " + kl);
                                    System.out.print(" ku = " + ku);
                                    System.out.println(" kk = " + kk);
                                    System.out.println("dp[i][j][k] = " + dp[i][j][k]);*/
                                }
                            }
                        }
                    }
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        int ref = 0;
        for (int k = 0; k < 4; k++) {
            for (int ku = 0; ku < 4; ku++) {
                if(k==ku)
                    continue;
                if(col[n-1][m-1][k][ku] < ans){
                    ans = col[n-1][m-1][k][ku];
                    ref = k + 4*ku;
                }
            }
        }
        int k = ref%4;
        int ku = ref/4;
        int[][] res = new int[n][m];
        for (int i = n-1; i > 0 ; i--) {
            for (int j = m - 1; j >= 0; j--) {
                res[i][j] = k;

                res[i-1][j] = ku;
                if (j > 0) {
                    ref = colp[i-1][j][k][ku];
                    k = ref % 4;
                    ku = ref / 4;
                }
            }
            ref = colp[i-1][m-1][res[i-1][m-1]][res[i-1][m-2]];
            k = res[i-1][m-1];
            ku = ref%4;

        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(chars[res[i][j]]);
            }
            out.println();
        }
        //out.println(ans);

    }
}
