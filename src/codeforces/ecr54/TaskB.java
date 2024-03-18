package codeforces.ecr54;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.nl();
        int ans = 0;
        if(n%2 != 0){
            ans++;
            long div = n;
            for (long i = 3; i*i <= n; i++) {
                if(n%i == 0){
                    div = i;
                    break;
                }
            }
            n-=div;
        }
        if(n == 0){
            out.println(ans);
        } else {
            out.println(ans + n/2);
        }


    }
}
