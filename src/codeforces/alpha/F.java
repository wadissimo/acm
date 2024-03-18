package codeforces.alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class F {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        do {
            int s = 0;
            int q = 0;
            while (n > 0) {
                q = n / 10;
                s = s + n - q * 10;
                n = q;
            }
            n = s;
        }while(n > 9);
        System.out.println(n);

    }
}
