package codeforces.r539;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), v = in.ni();
        if(v >= n-1){
            out.println(n-1);
            return;
        }
        int cur = 0;
        int ans = 0;
        for (int i = 1; i+cur < n; i++) {
            ans += (v-cur)*i;
            cur += (v-cur);
            if(n-i<=cur)
                break;
            cur--;
        }
        out.println(ans);
    }
}
