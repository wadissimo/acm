package codeforces.r244;

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
        int n = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int ans  = 0;
        int prev = -1;
        for (int i = 0; i < n; i++) {
            int a = Integer.parseInt(st.nextToken());
            if(a > t) {
                if(i - prev - 1 >= c) {
                    ans += i - prev - c;
                }
                prev = i;
            } else if(i == n-1) {
                if(i - prev >= c) {
                    ans += i - prev - c + 1;
                }

            }
        }
        System.out.println( ans);
        
    }
}
