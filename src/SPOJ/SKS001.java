package SPOJ;

import chelper.io.InputReader;
import common.IntegerUtils;

import java.io.PrintWriter;

public class SKS001 {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        long a = in.ni();
        long b = in.ni();
        if(a==b)
            out.println(0);
        else {
            boolean prime;
            long ans = a + 1;
            for (long i = b; i > a + 1; i--) {
                prime = true;
                for (int d = 2; d <= Math.sqrt(i); d++) {
                    if (i % d == 0) {
                        prime = false;
                        break;
                    }
                }
                if (prime) {
                    ans = i;
                    break;
                }
            }
            out.println((ans + b) * (b - ans + 1) / 2);
        }

    }
}
