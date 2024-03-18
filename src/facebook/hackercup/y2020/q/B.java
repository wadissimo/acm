package facebook.hackercup.y2020.q;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int N = in.ni();
            String s = in.ns();
            int aCnt = 0;
            for (int i = 0; i < N; i++) {
                if(s.charAt(i) == 'A')
                    aCnt++;
            }
            int bCnt = N-aCnt;
            out.printf("Case #%d: ", t+1);
            if(Math.abs(aCnt-bCnt) <= 1)
                out.println("Y");
            else
                out.println("N");
        }
    }
}
