package codeforces.r240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */
public class D {
    static int[] getMult(int n) {
        int[] res = new int[n/2 + 1];
        int resi = 0;
        for (int i = 1; i <= n/2; i++) {
            if(n%i==0) {
                res[resi] = i;
                resi++;
            }
        }
        res[resi] = n;
        int[]res2 = new int[resi+1];
        System.arraycopy(res, 0, res2, 0, resi+1);
        return res2;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());




        int[][] d = new int[n][];
        for (int i = 0; i < n; i++) {
            d[i] = getMult(i+1);
           // System.out.println((i+1) + "->"+Arrays.toString(d[i]));
        }

        long[][] a = new long[n+1][k];
        for (int i = 0; i < n; i++) {
            a[i+1][0] = 1;
        }
        for (int i = 1; i < k; i++) {

            for (int j = 1; j <= n; j++) {
                for (int m = 0; m < d[j - 1].length; m++) {
                    a[j][i] = (a[j][i] + a[j/d[j-1][m]][i-1]) % 1000000007;
                }
            }
        }
        long res = 0;
        for (int i = 0; i < n; i++) {
            res = (res + a[i+1][k-1])%1000000007;
        }
        System.out.println(res);
    }
}
