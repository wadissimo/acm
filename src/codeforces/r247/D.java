package codeforces.r247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Vadim
 */
public class D {

    static long calcM (long n, long[][] dp, int k) {
        int nbits = Long.bitCount(n);
        long res = 0;

        for (int j = 1; j < 64; j++) {
            if((n&1) == 1) {
                if(nbits==k){
                    res ++;
                }
                nbits--;
                if(nbits < k) {
                    res += dp[j - 1][k - nbits];
                }
            }
            n = n>>1;
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        long dp[][] = new long[64][k+1];
        dp[1][1] = 1;
        for (int i = 0; i < 64; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i <= k; i++) {
            for (int j = i; j < 64; j++) {
                dp[j][i] = dp[j-1][i] + dp[j-1][i-1];
            }
        }
        System.out.println(calcM(m, dp, k));

    }
}
