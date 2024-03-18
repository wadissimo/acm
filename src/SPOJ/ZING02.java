package SPOJ;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class ZING02 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            long l = in.nl();
            long r = in.nl();
            long d = r-l+1;
            int i = 0;
            while(1<<i < d)
                i++;
            long ans = (1<<i) - d;
            if(i > 0)
                ans = Math.min(ans, d-(1<<(i-1)));
            out.println(ans);
        }
    }
}
