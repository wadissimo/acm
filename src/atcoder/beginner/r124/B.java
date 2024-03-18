package atcoder.beginner.r124;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] h = in.na(n);
        int max = 0;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(h[i] >= max){
                ans++;
                max = h[i];
            }
        }
        out.println(ans);
    }
}
