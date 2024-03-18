package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class r467Ad1 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long k = in.nl(), d = in.nl(), t = in.nl();
        long c = (k+d-1)/d*d;
        long n = 2*t/(c+k);
        long rem = 2*t - n*(c+k);
        double ans = c*n;
        if(rem > 0){
            if(rem <= 2*k)
                ans += rem/2.0;
            else{
                rem -= 2*k;
                ans += k + rem;
            }
        }
        out.println(ans);
    }
}
