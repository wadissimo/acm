package SPOJ;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class FCTRL2a {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(reader.readLine());
        BigInteger f[] = new BigInteger[100];
        f[0] = BigInteger.ONE;
        for (int i = 1; i < 100; i++) {
            f[i] = f[i-1].multiply(BigInteger.valueOf(i+1));
        }
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(reader.readLine());
            System.out.println(f[n-1].toString());
        }
    }
}
