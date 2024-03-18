package codeforces.lyft2018;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class BA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int t = in.ni();
        for (int i = 0; i < t; i++) {
            long a = in.nl();
            long b = in.nl();
            if (a - b > 1) {
                out.println("NO");
            } else {
                long c = a + b;
                boolean prime = true;
                if (c % 2 == 0)
                    prime = false;
                else {
                    for (long j = 3; j * j <= c; j += 2) {
                        if (c % j == 0) {
                            prime = false;
                            break;
                        }
                    }
                }
                if (prime)
                    out.println("YES");
                else
                    out.println("NO");
            }
        }
    }
}
