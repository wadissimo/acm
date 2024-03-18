package atcoder.agc029;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        int n = s.length();
        int done = 0;
        long ans = 0;
        for (int dist = 0; dist < n; dist++) {
            if(s.charAt(n-dist-1) == 'B'){
                ans += dist-done;
                done++;
            }
        }
        out.println(ans);

    }
}
