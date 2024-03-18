package codeforces.round242;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        long p[] = new long[n];
        for (int i = 0; i < n; i++) {
            long pi = Long.parseLong(st.nextToken());
            p[i] = pi;
        }
        int[] xors = new int[n+1];
        xors[0] = 0;
        for (int i = 1; i < n +1; i++) {
            xors[i] = xors[i-1]^i;
        }
        int xorn = 0;
        for (int i = 2; i < n+1; i++) {
            if((n/i)%2 ==1) {
                xorn ^= xors[i-1];
            }
            xorn ^= xors[n%i];
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans ^= p[i];
        }
        ans ^= xorn;
        System.out.println(ans);
    }
}
