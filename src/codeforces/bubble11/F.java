package codeforces.bubble11;

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
        st = new StringTokenizer(reader.readLine());
        int[]w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i]=Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(reader.readLine());
        int x = Integer.parseInt(st.nextToken());
        int f = Integer.parseInt(st.nextToken());
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if(w[i] > x){
                ans += ((w[i]-x)/(x+f) + ((w[i]-x)%(x+f) == 0?0:1))*f;
            }
        }
        System.out.println(ans);

    }
}
