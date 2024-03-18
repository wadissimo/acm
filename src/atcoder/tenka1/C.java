package atcoder.tenka1;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        int[] wCnt = new int[n+1];
        for (int i = 0; i < n; i++) {
            wCnt[i+1] = wCnt[i];
            if(s.charAt(i) == '.')
                wCnt[i+1]++;
        }
        int best = n;
        for (int i = 0; i <= n; i++) {
            int blackLeft =i-wCnt[i];//excl
            int whiteRight = wCnt[n]-wCnt[i];
            best = Math.min(best, blackLeft+whiteRight);
        }
        out.println(best);
    }
}
