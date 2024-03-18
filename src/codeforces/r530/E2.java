package codeforces.r530;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class E2 {
    int sub(char[][] map, int n, int m, int[] bestAns){
        int[] ans = new int[n];
        int best = Integer.MAX_VALUE;
        for (int k1 = 0; k1 < 4; k1++) {
            for (int k2 = 0; k2 < 4; k2++) {
                if(k1 == k2)
                    continue;
                int k3 = 10, k4 = 0;
                for (int kk = 0; kk < 4; kk++) {
                    if(kk != k1 && kk != k2){
                        k3 = Math.min(k3, kk);
                        k4 = Math.max(k4, kk);
                    }
                }
                int sum = 0;
                for (int i = 0; i < n; i++) {
                    int subodd = 0, subeven = 0;
                    for (int j = 0; j < m; j++) {
                        int kodd;
                        int keven;
                        if(i%2 == 0) {
                            kodd = j % 2 == 0 ? k1 : k2;
                            keven = j % 2 == 0 ? k2 : k1;
                        } else {
                            kodd = j % 2 == 0 ? k3 : k4;
                            keven = j % 2 == 0 ? k4 : k3;
                        }
                        if (map[i][j] != kodd)
                            subodd++;
                        if (map[i][j] != keven)
                            subeven++;
                    }
                    if(subodd < subeven){
                        if(i%2 == 0)
                            ans[i] = k1 + 4*k2;
                        else
                            ans[i] = k3 + 4*k4;
                    } else {
                        if(i%2 == 0)
                            ans[i] = k2 + 4*k1;
                        else
                            ans[i] = k4 + 4*k3;
                    }
                    sum += Math.min(subodd, subeven);
                }
                /*System.out.print("k1 = " + k1);
                System.out.print(" k2 = " + k2);
                System.out.print(" k3 = " + k3);
                System.out.println(" k4 = " + k4);
                System.out.println("sum = " + sum);*/
                if(sum < best){
                    for (int i = 0; i < n; i++) {
                        bestAns[i] = ans[i];
                    }
                    best = sum;
                }
            }
        }
        //System.out.println("best = " + best);
        return best;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        char[][] map = in.nm(n, m);
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
        int[] hAns = new int[n];
        int hBest = sub(map, n, m, hAns);
        char[][] transpose = new char[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                transpose[j][i] = map[i][j];
            }
        }

        int[] vAns = new int[m];
        int vBest = sub(transpose, m, n, vAns);
        if(hBest <= vBest){
            for (int i = 0; i < n; i++) {
                int k1 = hAns[i]%4, k2 = hAns[i]/4;
                for (int j = 0; j < m; j++) {
                    out.print(chars[j%2==0?k1:k2]);
                }
                out.println();
            }
        } else {
            char[][]ans = new char[n][m];
            for (int i = 0; i < m; i++) {
                int k1 = vAns[i]%4, k2 = vAns[i]/4;
                for (int j = 0; j < n; j++) {
                    ans[j][i] = chars[j%2==0?k1:k2];
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    out.print(ans[i][j]);
                }
                out.println();
            }
        }
    }
}
