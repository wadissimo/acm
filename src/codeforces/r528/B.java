package codeforces.r528;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int k = in.ni();
        int min = Integer.MAX_VALUE;
        for (int div = 1; div*div <= n; div++) {
            if(n%div == 0){
                int rem = n/div;
                if(rem < k){
                    int x = div*k + rem;
                    if(x < min)
                        min = x;
                }
                if(div < k){
                    int x = rem*k + div;
                    if(x < min)
                        min = x;
                }
            }
        }
        out.println(min);
    }
}
