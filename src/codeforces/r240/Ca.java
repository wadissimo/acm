package codeforces.r240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class Ca {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());


        if(k == 0 || n == 1) {
            if(n == 1 && k == 0) {
                System.out.println("1");
            } else {
                System.out.println("-1");
            }
        }else {
            long d = k-(n/2-1);
            if(d > 0) {
                System.out.print(d + " " + d * 2 + " ");
                for (int i = 0; i < n / 2 - 1; i++) {
                    System.out.print((d * 2 + (i * 2 + 1)) + " " + (d * 2 + (i * 2 + 2)) + " ");
                }
                if(n%2 == 1) {
                    System.out.println((d * 2 + ((n/2)*2 - 1)));
                }
                System.out.println("");
            } else {
                System.out.println("-1");
            }

        }

    }
}
