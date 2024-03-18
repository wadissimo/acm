package codeforces.r554;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long a = in.ni(), b = in.ni();
        long dif = Math.abs(a-b);
        long min = a*b/ IntegerUtils.gcd(a,b);
        long best = 0;
        for (int div = 1; div*div <= dif ; div++) {
            if(dif%div == 0){
                if(a%div == b%div){
                    long k = div-a%div;
                    long res = (a+k)*(b+k)/div;
                    if(res < min || res == min && k < best){
                        best = k;
                        min = res;
                    }
                }
                if(div*div < dif){
                    long num = dif/div;
                    if(a%num == b%num) {
                        long k = num - a % num;
                        long res = (a + k) * (b + k) / num;
                        if (res < min || res == min && k < best) {
                            best = k;
                            min = res;
                        }
                    }
                }
            }
        }
        out.println(best);
    }
}
