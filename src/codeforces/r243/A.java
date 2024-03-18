package codeforces.r243;

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
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int sum = 0;
        int max = 0;
        for (int i = 0; i < n; i++) {
            int c = Integer.parseInt(st.nextToken());
            sum += c;
            if(c > max) {
                max = c;
            }
        }
        if( sum - max > s) {
            System.out.println("NO");
        } else {
            System.out.println("YES");
        }



    }
}
