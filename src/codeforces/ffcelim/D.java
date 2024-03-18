package codeforces.ffcelim;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long m = in.ni();
        int a = in.ni(), b = in.ni();
        long gcd = IntegerUtils.gcd(a,b);

        int[]shift = new int[a];
        for (int i = 1; i < a; i++) {
            shift[a-i*b%a] = i*b;
        }
        long ans = m;//0s
        for (int z = 1; z < a; z++) {
            if(z%gcd != 0){
                continue;
            }
            long from = z+shift[z];
            if(from <= m){
                long cnt = (m-from)/a+1;
                ans += cnt*(m+1)-(2*from+(cnt-1)*a)*cnt/2;
            }
        }
        out.println(ans);

        for (int z = 0; z < 100; z++) {
            if(z%gcd != 0)
                continue;
            System.out.print("z = " + z);
            for (int i = z; i < 1000; i++) {
                if(i%a == 0 && i%b == z%b){
                    System.out.print(" m = " + i);
                    System.out.println("  (m-z) = " + (i - z));
                    break;
                }
            }
        }
        for (int i = 0; i < 4*b; i++) {
            System.out.print("(i*a) = " + (i * a));
            System.out.println("    (i*a%b) = " + (i * a % b));
        }
    }
}
