package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class DDivRemNumber {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long N = in.nl();
        long ans = 0;
        for (long div = 1; div*div < N ; div++) {
            if(N%div == 0){
                long m = N / div - 1;
                if(div < m){
                    ans += m;
                }
            }
        }
        out.println(ans);
    }
}
