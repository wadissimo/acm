package codeforces.r518;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n  = in.ni();
        int m = in.ni();
        boolean a[][] = new boolean[n][n];
        for (int i = 0; i < m; i++) {
            int x = in.ni()-1;
            int y = in.ni()-1;
            a[x][y] = true;
            a[y][x] = true;
        }
        LinkedList<Integer>[] ans = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            ans[i] = new LinkedList();
        }
        int col = 0;
        for (int i = 0; i < n; i++) {
            int cnt = 0;
            for (int j = 0; j < i; j++) {
                if(a[j][i]){
                    cnt++;
                    ans[j].add(col);
                    ans[i].add(col);
                    col++;
                }
            }
            if(cnt == 0) {
                ans[i].add(col);
                col++;
            }
        }
        for (int i = 0; i < n; i++) {
            out.println(ans[i].size());
            for (Integer y : ans[i]) {
                out.println((i+1) + " " + (y+1));
            }
        }
    }
}
