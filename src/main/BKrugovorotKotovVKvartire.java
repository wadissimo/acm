package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class BKrugovorotKotovVKvartire {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            long n = in.nl();
            long k = in.nl()-1;
            if(n%2 == 0){
                out.println(k%n+1);
            } else {
                long d = (k % ((n-1)/2))*2;
                long apos = n-k%n;
                long bpos = (apos + d)%n+1;
                out.println(bpos);
            }
        }
    }
}
