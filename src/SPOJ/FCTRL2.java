package SPOJ;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.math.BigInteger;

public class FCTRL2 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        BigInteger f[] = new BigInteger[100];
        f[0] = BigInteger.ONE;
        for (int i = 1; i < 100; i++) {
            f[i] = f[i-1].multiply(BigInteger.valueOf(i+1));
        }
        int t = in.ni();
        for (int i = 0; i < t; i++) {
            int n = in.ni();
            out.println(f[n-1].toString());
        }
    }
}
