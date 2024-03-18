package codeforces.r518;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long b  = in.nl();
        if(b == 1){
            out.println(1);
        } else {
            int ans = 2;
            for (long div = 2; div * div <= b; div++) {
                if (b % div == 0) {
                    if(div*div == b){
                        ans+=1;
                    }else
                        ans += 2;
                }
            }
            out.println(ans);
        }
    }
}
