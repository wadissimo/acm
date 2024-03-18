package codeforces.r247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Vadim
 */
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int r = n-d;
        if(d > n) {
            System.out.println(0);
        }else
        if(r == 0) {
            System.out.println(1);
        } else {
            long dp[] = new long[r+1];
            dp[0] = 1;
            dp[1] = 1;
            for (int i = 2; i <= r; i++) {
                long sum = 0;
                for (int j = 1; j <= Math.min(k, i); j++) {
                    sum = (sum + dp[i-j])%1000000007L;
                }
                dp[i] = sum;
            }

            long f [] = new long[n+1];
            f[0] = 0;
            f[1] = 0;
            for (int i = d; i <= n; i++) {
                for (int j = 1; j < d; j++) {
                    if(i<j) break;
                    f[i] = (f[i] + f[i-j])%1000000007L;
                }

                for (int j = d; j <= Math.min(k, i); j++) {
                    f[i] = (f[i] + dp[i-j])%1000000007L;
                }
            }
            System.out.println(f[n]);
        }

    }
}
