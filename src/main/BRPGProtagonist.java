package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class BRPGProtagonist {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            long p = in.ni(), f = in.ni();
            long cs = in.ni(), cw = in.ni();
            long s = in.ni(), w = in.ni();
            if(w < s){
                long tmp = w; w = s; s = tmp;
                tmp = cs; cs = cw; cw = tmp;
            }
            long ans = 0;
            for (int i = 0; i <= cs && i*s <= p; i++) { // how many first takes
                if((f-(cs-i)*s) < 0) {// second takes all
                    long wtaken = (p - i * s) / w;
                    wtaken = Math.min(wtaken, cw);
                    ans = Math.max(ans, i + wtaken+ f/s);
                } else {
                    long wtaken = (p - i * s) / w + (f - (cs - i) * s) / w;
                    wtaken = Math.min(wtaken, cw);
                    ans = Math.max(ans, wtaken + cs);
                }
            }
            out.println(ans);
        }
    }
}
