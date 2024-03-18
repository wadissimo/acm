package codeforces.r244;

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
        int sum = 0;
        int ans = 0;
        for (int i = 0; i <n; i++) {
            int a = Integer.parseInt(st.nextToken());
            sum+=a;
            if(sum < 0) {
                ans++;
                sum -=a;
            }


        }
        System.out.println(ans);

    }
}
