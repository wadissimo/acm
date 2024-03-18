package codeforces.r514;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int L = in.ni();
        int a = in.ni();
        int tp = 0;
        int lp = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int t = in.ni();
            int l = in.ni();
            ans += (t-tp-lp)/a;
            tp = t;
            lp = l;
        }
        ans += (L-tp-lp)/a;
        out.println(ans);

    }
}
