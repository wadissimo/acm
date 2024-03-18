package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 08.05.2014.
 */
public class A1012 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(st.nextToken());
        BigInteger[]d = new BigInteger[n];
        d[0] = BigInteger.valueOf(k-1);
        d[1] = d[0].multiply(BigInteger.valueOf(k-1)).add(BigInteger.valueOf(k - 1));
        for (int i = 2; i < n; i++) {
            d[i] = d[i-1].multiply(BigInteger.valueOf(k-1)).add(BigInteger.valueOf(k-1).multiply(d[i-2]));
        }
        System.out.println(d[n-1]);

    }
}
