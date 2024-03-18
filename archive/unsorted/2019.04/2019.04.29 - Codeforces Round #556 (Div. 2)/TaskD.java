package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Stack;

public class TaskD {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        String s = in.ns();
        int SIGMA = 26;
        int[][] prev = new int[n+1][SIGMA];
        int[] idx = new int[SIGMA];
        Arrays.fill(idx,-1);
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < SIGMA; j++) {
                prev[i][j] = idx[j];
            }
            if(i == n)
                break;
            char c = s.charAt(i);
            idx[c-'a'] = i;
        }
        Arrays.fill(idx,-1);
        int[][] next = new int[n+1][SIGMA];
        for(int i = n-1; i >= 0;i--){
            for (int j = 0; j < SIGMA; j++) {
                next[i+1][j] = idx[j];
            }
            char c = s.charAt(i);
            idx[c-'a'] = i;
        }
        for (int j = 0; j < SIGMA; j++) {
            next[0][j] = idx[j];
        }
        int [][][] dp = new int[3][3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    dp[i][j][k] = -1;
                }
            }
        }
        int[][] ids = {{0,1,2},{0,2,1},{1,0,2},{1,2,0},{2,0,1},{2,1,0}};
        for (int i = 0; i < 6; i++) {
            dp[ids[i][0]][ids[i][1]][ids[i][2]] = 0;
        }
        Stack<Integer>[] st = new Stack[3];
        for (int i = 0; i < 3; i++) {
            st[i] = new Stack<>();
        }
        for (int i = 0; i < m; i++) {
            char op = in.ns().charAt(0);
            int id = in.ni()-1;
            char c = in.ns().charAt(0);
            int d = c-'a';
            if(op == '+'){
                for (int j = 0; j < 6; j++) {
                    if(dp[ids[i][0]][ids[i][1]][ids[i][2]] != -1){


                    }
                }
                st[id].push(d);
            }
        }

    }
}
