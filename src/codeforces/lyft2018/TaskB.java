package codeforces.lyft2018;

import chelper.io.InputReader;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.ArrayList;

public class TaskB {

    static long ferma(long n){
        long x = (long) Math.ceil(Math.sqrt(n));
        long y = 0;
        long r = x*x - y*y - n;
        while(true) {
            if (r == 0)
                return x != y ? x - y : x + y;
            else if (r > 0) {
                r -= y + y + 1;
                ++y;
            } else {
                r += x + x + 1;
                ++x;
            }
        }
    }
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        ArrayList<Integer> pr = new ArrayList<>(80000);
        int[] lp = new int[1000001];
        IntegerUtils.sieve(1000000, pr, lp);
        int t = in.ni();
        for (int i = 0; i < t; i++) {
            long a = in.nl();
            long b = in.nl();
            if(a-b > 1){
                out.println("NO");
            } else {
                long c = a+b;
                boolean prime = true;
                for (Integer p : pr) {
                    if(p >= c)
                        break;
                    if(c%p == 0){
                        prime = false;
                        break;
                    }
                }
                if(prime)
                    out.println("YES");
                else
                    out.println("NO");
            }
        }
    }
}
