package codeforces.r553;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Arrays;

public class C {
    long mod = (int)1e9+7;

    long calc(long num){
        if(num == 0)
            return 0;
        boolean odd = true;
        long size = 1;
        long oddSize = 0;
        long evenSize = 0;
        while(num > 0){
            if(num <= size)
                break;
            num -= size;
            if(odd)
                oddSize += size;
            else
                evenSize += size;
            odd = !odd;
            size*=2;
        }
        if(odd)
            oddSize+=num;
        else
            evenSize += num;
        return (oddSize%mod*(oddSize%mod) + (evenSize+1)%mod*(evenSize%mod))%mod;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long l = in.nl(), r = in.nl();
        long lr = calc(l-1);
        long rr = calc(r);
        out.println((rr-lr+mod)%mod);
    }
}
