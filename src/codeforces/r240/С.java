package codeforces.r240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class С {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long gcd = k / (n/2);
        if (gcd == 0) {
            System.out.println(-1);
        } else {
            for (long i = 0; i < n / 2; i++) {
                if(i == n/2 - 1) {
                    long lastgcd = k%(n/2) + gcd;
                    System.out.print((i*2+1)*lastgcd + " " + (i*2+2)*lastgcd + " ");
                    if(n%2 == 1) {
                        System.out.println((i*2+2)*lastgcd + 1);
                    } else {
                        System.out.println("");
                    }
                } else {
                    System.out.print((i * 2 + 1) * gcd + " " + (i * 2 + 2) * gcd + " ");
                }
            }
        }

    }
}
