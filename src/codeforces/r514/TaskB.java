package codeforces.r514;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskB {

    static boolean check(char[][] a, int[][] mark, int i, int j){
        if(a[i][j] == '#' && a[i+2][j+2] == '#' && a[i+2][j+1] == '#' && a[i+2][j] == '#' && a[i+1][j+2] == '#' && a[i+1][j] == '#'&&
                a[i][j+2] == '#' && a[i][j+1] == '#'){
            mark[i][j] = 1;
            mark[i+2][j+2] = 1;
            mark[i+2][j+1] = 1;
            mark[i+2][j] =  1;
            mark[i+1][j+2] = 1;
            mark[i+1][j] = 1;
            mark[i][j+2] = 1;
            mark[i][j+1] = 1;
            return true;
        }
        return false;
    }
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int m = in.ni();
        char[][] a = new char[n][m];
        int[][] mark = new int[n][m];
        for (int i = 0; i < n; i++) {
            String s = in.ns();
            for (int j = 0; j < m; j++) {
                a[i][j] = s.charAt(j);
            }
        }
        boolean ans = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(a[i][j] == '#'){
                    boolean possible = false;
                    if(i > 1 && j > 1){
                        possible |= check(a, mark, i-2, j-2);
                    }
                    if(i < n-2 && j < m-2){
                        possible |= check(a, mark, i, j);
                    }
                    if(i < n-2 && j > 1){
                        possible |= check(a, mark, i, j-2);
                    }
                    if(i > 1 && j < m-2){
                        possible |= check(a, mark, i-2, j);
                    }
                    if(mark[i][j] == 0 && !possible){
                        ans = false;
                    }
                }
            }
        }
        if(ans)
            out.println("YES");
        else
            out.println("NO");
    }
}
