package codeforces.r240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());

        long n = Long.parseLong(st.nextToken());
        long a = Long.parseLong(st.nextToken());
        long b = Long.parseLong(st.nextToken());

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            long w = Long.parseLong(st.nextToken());
            System.out.print(((w * a) % b) / a + " ");
        }
        System.out.println("");
    }
}
