package codeforces.r239;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int p[] = new int[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            p[i] = Integer.parseInt(st.nextToken());
        }
        long a[] = new long[n];
        a[0] = 2;
        for (int i = 1; i < n; i++) {
            if(p[i] == 1) {
                a[i] = (2 * a[i - 1] + 2) % 1000000007;
            }else {
                a[i] = (1000000007 + 2 * a[i - 1] - a[p[i] - 2] + 2)%1000000007;
            }
        }
        System.out.println(a[n-1]%1000000007);

    }
}
