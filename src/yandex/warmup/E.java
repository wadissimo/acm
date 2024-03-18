package yandex.warmup;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 16.05.2014.
 */
public class E {
    static BigInteger nf(int n) {
        BigInteger res = BigInteger.ONE;
        for (int i = 2; i <= n; i++) {
            res = res.multiply(BigInteger.valueOf(i));
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        BigInteger sum = BigInteger.ZERO;
        for (int i = 0; i <= n; i++) {
            sum = sum.add(nf(i).pow(k));
        }
        String res = sum.toString();
        for (int i = res.length()-1; i >= 0; i--) {
            if(res.charAt(i) != '0') {
                System.out.println(res.charAt(i));
                break;
            }
        }
    }
}
