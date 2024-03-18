package atcoder.beginner.r121;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class D {
    long f(long a){
        if(a%2 == 1){
            if((a&2) == 0){
                return 1;
            } else {
                return 0;
            }
        }
        long res = 0;
        for (int i = 60; i >= 1; i--) {
            if((a&(1L<<i)) != 0){
                res |= (1L<<i);
            }
        }
        if((a&2) == 0){
            return res;
        } else {
            return res|1;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long a = in.nl(), b = in.nl();
        if(a == 0)
            out.println(f(b));
        else
            out.println(f(b)^f(a-1));

    }
}
