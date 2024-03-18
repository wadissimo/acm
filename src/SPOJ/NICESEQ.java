package SPOJ;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class NICESEQ {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int t = in.ni();
        BigInteger mod = BigInteger.valueOf(1000000007);
        for (int c = 0; c < t; c++) {
            int n = in.ni();
            long ans = 0;
            if(n==1){
                ans = 9;
            }else{
                n--;
                BigInteger exp = BigInteger.valueOf(n);
                ans = 1;//1
                ans += BigInteger.valueOf(5).modPow(exp, mod).longValue();//2
                ans += BigInteger.valueOf(4).modPow(exp, mod).longValue();//3
                ans += BigInteger.valueOf(3).modPow(exp, mod).longValue();//4
                ans += 5*BigInteger.valueOf(2).modPow(exp, mod).longValue();//5-9
                ans %= 1000000007L;
            }
            out.println(ans);
        }
    }
}
