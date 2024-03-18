package codeforces.r239;

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
        st = new StringTokenizer(reader.readLine());
        int []k = new int [n];
        for (int i = 0; i < n; i++) {
            k[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int minK = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int time = 0;
            for (int j = 0; j < k[i]; j++) {
                int m = Integer.parseInt(st.nextToken());
                time += m*5 + 15;
            }
            if(time < min) {
                min = time;
                minK = i;
            }
        }
        System.out.println( min);
    }
}
