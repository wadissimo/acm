package codeforces.vkr3;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskF {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int t = in.ni();
        int q[] = new int[n];
        int ti[] = new int[n];
        for (int i = 0; i < n; i++) {
            ti[i] = in.ni();
            q[i] = in.ni();
        }
        int max = (int)(Math.log(n)/Math.log(2));
        if(Math.pow(2, max) < n) max++;
        long res = 0;
        for (int l = 0; l <= max; l++) {


            int tt = t-l;
            int a[][] = new int[n + 1][tt + 1];
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= tt; j++) {
                    if (j >= ti[i - 1]) {
                        a[i][j] = Math.max(a[i - 1][j], a[i - 1][j - ti[i-1]] + q[i-1]);
                    } else {
                        a[i][j] = a[i - 1][j];
                    }
                }
            }
            res = Math.max(res, a[n][tt]);
        }
        out.println(res);
    }
}
