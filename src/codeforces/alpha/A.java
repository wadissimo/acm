package codeforces.alpha;

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
        int preva1 = 0;
        int preva2 = 0;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(i==0) {
                System.out.print(a * 3 + " ");
            } else if(i==1){
                System.out.print((a * 3 + 2 * preva1) + " ");
            } else {
                System.out.print((a * 3 + 2 * preva1 + preva2) + " ");
            }
            preva2 = preva1;
            preva1 = a;

        }
        System.out.println("");
    }
}
