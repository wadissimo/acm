package codeforces.r454;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;

public class D {
    boolean check(int[][] ans, int cola, int colb){
        int n = ans.length;
        int m = ans[0].length;
        for (int i = 0; i < n; i++) {
            if(Math.abs(ans[i][cola]-ans[i][colb]) == m)
                return false;
            if((ans[i][cola]-1)/m == (ans[i][colb]-1)/m && Math.abs(ans[i][cola]-ans[i][colb]) == 1)
                return false;
        }
        return true;
    }
    void rotate(int[][] ans, int col){
        int t = ans[0][col];
        for (int i = 0; i < ans.length-1; i++) {
            ans[i][col] = ans[i+1][col];
        }
        ans[ans.length-1][col] = t;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        if(n==1 &&m ==1){
            out.println("YES");
            out.println("1");
            return;
        }
        if(n <=2 && m <=2 || n==2 && m == 3 || m == 2 && n == 3 || n == 1 &&m ==3 || n == 3&& m == 1){
            out.println("NO");
            return;
        }
        int[][] ans;
        if(n == 3 && m == 3){
            ans = new int[][]{{1,7,6},{5,9,2}, {3,4,8}};
        } else if(n== 1 && m == 4){
            ans = new int[][]{{3, 1, 4, 2}};
        }else if(n == 4 && m == 1){
            ans = ArrayUtils.reverse(new int[][]{{3, 1, 4, 2}});
        } else {
            boolean rev = false;
            int rn = n;int rm = m;
            if(n>m){
                rev = true;
                rn = m;
                rm = n;
            }
            int[][] map = new int[n][m];
            int cnt = 1;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    map[i][j] = cnt++;
                }
            }
            ans = new int[rn][rm];
            int x = 0, y = 0;
            for (int r = 0; r < 2; r++) {
                for (int i = 0; i < n; i++) {
                    for (int j = 0; j < m; j++) {
                        if ((i + j) % 2 == r) {
                            ans[x++][y] = map[i][j];
                            if (x == rn) {
                                x = 0;
                                y++;
                            }
                        }
                    }
                }
            }

            int col = rm/2;
            if(!check(ans, col-1, col)){
                rotate(ans, col-1);
            }
            if(!check(ans, col-1, col)){
                rotate(ans, col-1);
            }
            if(!check(ans, col-1, col))
                throw new RuntimeException();
            if(rm%2 == 1){
                if(!check(ans, col, col+1)){
                    rotate(ans, col+1);
                }
                if(!check(ans, col, col+1)){
                    rotate(ans, col+1);
                }
                if(!check(ans, col, col+1))
                    throw new RuntimeException();
            }


            if(rev){
                ans = ArrayUtils.reverse(ans);
            }

        }

        out.println("YES");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                out.print(ans[i][j] + " ");
            }
            out.println();
        }
    }
}
