package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 08.05.2014.
 */
public class A1009 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(st.nextToken());
        long[]d = new long[n];
        d[0] = k-1;
        d[1] = d[0]*(k-1) + (k - 1);
        for (int i = 2; i < n; i++) {
            d[i] = d[i-1]*(k-1) + (k-1)*d[i-2];
        }
        System.out.println(d[n-1]);

    }
}
