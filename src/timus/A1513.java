package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 07.05.2014.
 */
public class A1513 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        if(k == 0) {
            System.out.println(1);
        } else{
            BigInteger[] a = new BigInteger[n];
            a[0] = new BigInteger("2");
            BigInteger two = new BigInteger("2");
            for (int i = 1; i < k; i++) {
                a[i] = a[i-1].multiply(two);
            }
            if(k < n) {
                for (int i = k; i < n; i++) {
                    a[i] = a[i-1].multiply(two);
                    if(i-k>1) {
                        a[i] = a[i].subtract(a[i-k-2]);
                    }else {
                        a[i] = a[i].subtract(BigInteger.ONE);
                    }
                }
            }
            System.out.println(a[n-1]);
        }

    }
}

