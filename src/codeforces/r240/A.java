package codeforces.r240;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int[] a = new int[n];
        int minB = n+1;
        for (int i = 0; i < m; i++) {
            int b = Integer.parseInt(st.nextToken());
            if(b < minB) {
                for (int j = b; j < minB ; j++) {
                    a[j - 1] = b;
                }
                minB = b;
            }
        }
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
}
