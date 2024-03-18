package atcoder.beginner.r121;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni(), c = in.ni();
        int[] b = in.na(m);
        int[][] a = new int[n][];
        for (int i = 0; i < n; i++) {
            a[i] = in.na(m);
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            long res = c;
            for (int j = 0; j < m; j++) {
                res += a[i][j]*b[j];
            }
            if(res > 0)
                ans++;
        }
        out.println(ans);

    }
}
