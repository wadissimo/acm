package atcoder.beginner.r124;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        int n = s.length();
        int[] res = new int[2];
        for (int first = 0; first <=1 ; first++) {
            int cur = first;
            for (int i = 0; i < n; i++) {
                if(s.charAt(i)-'0' != cur)
                    res[first]++;
                cur = 1-cur;
            }
        }
        out.println(Math.min(res[0], res[1]));
    }
}
