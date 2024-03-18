package codeforces.r300;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int m = in.ni();
        int d[] = new int[m];
        int h[] = new int[m];
        for (int i = 0; i < m; i++) {
            d[i] = in.ni();
            h[i] = in.ni();
        }
        int max = h[0];
        for (int i = 0; i < m; i++) {
            if(i == 0) {
                if(d[i] != 1) {
                    max = Math.max(max, h[i] + d[i] - 1);
                }
            } else {
                if(d[i] - d[i-1] < Math.abs(h[i] - h[i-1])) {
                    out.println("IMPOSSIBLE");
                    return;
                }
                max = Math.max(max, Math.max(h[i], h[i-1]) + (d[i] - d[i-1] - Math.abs(h[i] - h[i-1]))/2);
            }
        }
        if(d[m-1] != n) {
            max = Math.max(max, h[m-1] + n - d[m-1]);
        }
        out.println(max);
    }
}
