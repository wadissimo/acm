package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class AdaAndZoo {
    int [][] dist;
    int INF = 1_000_000_000;
    int NN;
    int N;
    int[][] h;
    int[][] pos;
    long cntr = 0;

    void go(int x, int y, int tx, int ty){
        int from = pos[x][y];
        int to = pos[tx][ty];
        cntr++;
        if(tx > 0 && dist[from][to] + Math.abs(h[tx][ty]-h[tx-1][ty]) < dist[from][pos[tx-1][ty]]) {
            dist[from][pos[tx-1][ty]] = dist[from][to] + Math.abs(h[tx][ty]-h[tx-1][ty]);
            go(x, y, tx - 1, ty);
        }
        if(ty > 0 && dist[from][to] + Math.abs(h[tx][ty]-h[tx][ty-1]) < dist[from][pos[tx][ty-1]]) {
            dist[from][pos[tx][ty-1]] = dist[from][to] + Math.abs(h[tx][ty]-h[tx][ty-1]);
            go(x, y, tx, ty-1);
        }
        if(tx < N-1 && dist[from][to] + Math.abs(h[tx][ty]-h[tx+1][ty]) < dist[from][pos[tx+1][ty]]) {
            dist[from][pos[tx+1][ty]] = dist[from][to] + Math.abs(h[tx][ty]-h[tx+1][ty]);
            go(x, y, tx + 1, ty);
        }
        if(ty < N-1 && dist[from][to] + Math.abs(h[tx][ty]-h[tx][ty+1]) < dist[from][pos[tx][ty+1]]) {
            dist[from][pos[tx][ty+1]] = dist[from][to] + Math.abs(h[tx][ty]-h[tx][ty+1]);
            go(x, y, tx, ty+1);
        }
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            cntr = 0;
            N = in.ni();

            h = in.nmi(N, N);
            int Q = in.ni();

            pos = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    pos[i][j] = N*i + j;
                }
            }
            int[] endPos = new int[Q];
            for (int i = 0; i < Q; i++) {
                int x = in.ni(), y = in.ni();
                endPos[i] = pos[x][y];
            }
            NN = N*N;
            dist = new int[NN][NN];
            for (int i = 0; i < NN; i++) {
                for (int j = 0; j < NN; j++) {
                    dist[i][j] = INF;
                }
            }
            for (int i = 0; i < NN; i++) {
                dist[i][i] = 0;
            }

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    go(i,j,i,j);
                }
            }

            int[][] dp = new int[NN][1<<Q];
            for (int i = 0; i < NN; i++) {
                Arrays.fill(dp[i], INF);
            }
            for (int i = 0; i < Q; i++) {
                dp[endPos[i]][1<<i] = 0;
            }
            long cntr2 = 0;
            long ans = 0;
            for (int mask = 1; mask < 1 << Q; mask++) {
                int subAns = INF;
                for (int i = 0; i < NN; i++) {
                    for (int subMask = (mask-1)&mask; subMask > 0 ; subMask = (subMask-1)&mask) {
                        dp[i][mask] = Math.min(dp[i][mask], dp[i][subMask]+dp[i][mask^subMask]);
                        cntr2++;
                    }
                    for (int j = 0; j < NN; j++) {
                        dp[j][mask] = Math.min(dp[j][mask], dp[i][mask] + dist[i][j]);
                        cntr2++;
                    }
                }
                for (int i = 0; i < NN; i++) {
                    subAns = Math.min(subAns, dp[i][mask]);
                    cntr2++;
                }
                ans += subAns;
            }

            out.println(ans);
            System.out.println("cntr = " + cntr);
            System.out.println("cntr2 = " + cntr2);
        }
    }
}
