package codeforces.r477;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), s = in.ni();
        int prevH = 0, prevM = -1;
        for (int i = 0; i < n; i++) {
            int h = in.ni(), m = in.ni();
            if(i == 0){
                if(h*60+m-s > 0) {
                    out.println("0 0");
                    return;
                }
            } else {
                int dif = (h - prevH) * 60 + m - prevM - 1;
                if (dif > 2 * s) {
                    break;
                }
            }
            prevH = h;
            prevM = m;
        }
        int ans = prevH*60+prevM+1+s;
        out.printf("%d %d%n", ans/60, ans%60);
    }
}
