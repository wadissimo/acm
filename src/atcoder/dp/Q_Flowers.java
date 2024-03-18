package atcoder.dp;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class Q_Flowers {

    long[] t;
    public long get(int r) {
        long ans = 0;
        while (r >= 0) {
            ans = Math.max(t[r], ans);
            r = (r & (r + 1)) - 1;
        }
        return ans;
    }

    public void set(int pos, long val) {
        while (pos < t.length) {
            t[pos] = Math.max(val, t[pos]);
            pos |= pos + 1;
        }
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] h = in.na(n);
        int[] a = in.na(n);
        t = new long[n+3];
        for (int i = 0; i < n; i++) {
            long best = get(h[i]-1);
            set(h[i], a[i]+best);
        }
        out.println(get(n));
    }
}
