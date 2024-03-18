package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 08.05.2014.
 */
public class A1172 {
    static int ind(int a, int b, int c) {
        return a + (b << 5) + (c << 10);
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        BigInteger[][] d = new BigInteger[ind(n+1, n+1, n+1)][3];

        d[ind(1,0,0)][0] = BigInteger.ONE;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                for (int k = 0; k <= n; k++) {
                    if(i > 1) {
                        d[ind(i, j, k)][0] = (d[ind(i - 1, j, k)][1].add(d[ind(i - 1, j, k)][2])).multiply(BigInteger.valueOf(n - i + 1));
                    } else{
                        if(j==0 && k ==0) {
                            d[ind(1,0,0)][0] = BigInteger.ONE;
                        } else {
                            d[ind(i, j, k)][0] = BigInteger.ZERO;
                        }
                    }
                    if(j>0) {
                        d[ind(i, j, k)][1] = (d[ind(i, j - 1, k)][0].add(d[ind(i, j - 1, k)][2])).multiply(BigInteger.valueOf(n - j + 1));
                    } else {
                        d[ind(i, j, k)][1] = BigInteger.ZERO;
                    }
                    if(k>0) {
                        d[ind(i, j, k)][2] = (d[ind(i, j, k - 1)][1].add(d[ind(i, j, k - 1)][0])).multiply(BigInteger.valueOf(n - k + 1));
                    } else {
                        d[ind(i, j, k)][2] = BigInteger.ZERO;
                    }

                }
            }
        }
        System.out.println((d[ind(n,n,n)][1].add(d[ind(n,n,n)][2])).divide(BigInteger.valueOf(2)));


    }
}
