package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class R474D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int q = in.ni();
        long[] ks = new long[60];
        long[] pows = new long[60];
        for (int i = 0; i < 60; i++) {
            pows[i] = 1L<<i;
        }
        for (int i = 0; i < q; i++) {
            int op = in.ni();
            if(op == 1){
                long x = in.nl(), k = in.nl();
                int level = Long.numberOfTrailingZeros(Long.highestOneBit(x));
                ks[level] = (ks[level] + k) % pows[level];
            } else if(op == 2){
                long x = in.nl(), k = in.nl();
                int level = Long.numberOfTrailingZeros(Long.highestOneBit(x));
                for (int j = level; j < 60; j++) {
                    k %= pows[j];
                    ks[j] = (ks[j] + k) % pows[j];
                    k*=2L;
                }
            } else {
                long x = in.nl();
                if(x == 1){
                    out.println(1);
                    continue;
                }
                int level = Long.numberOfTrailingZeros(Long.highestOneBit(x));
                long posInt = (x - (1L<<level) + ks[level])%pows[level];
                if(posInt < 0)
                    posInt = (posInt + pows[level])%pows[level];
                long pos = (1L<<level) + posInt;
                out.print(x + " ");
                for (int j = level-1; j > 0 ; j--) {
                    pos >>= 1;
                    long numInt = (pos - (1L<<j) - ks[j])%pows[j];
                    if(numInt < 0)
                        numInt = (numInt + pows[j])%pows[j];
                    long y = (1L<<j) + numInt;
                    out.print(y + " ");
                }
                out.println('1');
            }
        }
    }
}
