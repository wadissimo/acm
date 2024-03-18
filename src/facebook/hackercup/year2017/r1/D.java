package facebook.hackercup.year2017.r1;

import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Vadimka on 15.01.2017.
 */
public class D {
    static final BigInteger modulo = BigInteger.valueOf(1000000007);
    static BigInteger f [] = new BigInteger[100000000];
    static void calcF() {
        f[0] = BigInteger.ONE;
        f[1] = BigInteger.ONE;
        for (int i = 2; i < 1000000000 ; i++) {
            f[i] = f[i-1].multiply(BigInteger.valueOf(i)).mod(modulo);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("c:/DEV/acm/tests/facebook/year2017/r1/beach_umbrellas.txt"));
        BufferedWriter w = new BufferedWriter(new FileWriter("c:/DEV/acm/tests/facebook/year2017/r1/beach_umbrellas_out.txt"));

        calcF();
        int t = Integer.parseInt(r.readLine()); // number of cycles
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int c[] = new int[n];
            int sum = 0;
            for (int j = 0; j < n; j++) {
                c[j] = Integer.parseInt(r.readLine());
                sum += c[j];
            }
            if(n == 1) {
                w.write("Case #" + (i+1) + ": " + m + "\n");
            } else {
                BigInteger ans = BigInteger.ZERO;
                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (k == j) continue;
                        int free = m - 1 - 2 * sum + c[j] + c[k]; //free space between umbrellas
                        if(free >= 0) {
                            int N = n + 1;
                            int K = free;
                            BigInteger res = f[N + K - 1].divide(f[K]).divide(f[N - 1]);
                            res = res.multiply(f[n - 2]);

                            ans = ans.add(res);
                        }
                    }
                }

                ans = ans.mod(modulo);
                w.write("Case #" + (i+1) + ": " + ans + "\n");
            }
        }
        w.close();

    }
}
