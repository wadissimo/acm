package codeforces.r247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Vadim
 */
public class A {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int a[] = new int[4];
        a[0] = Integer.parseInt(st.nextToken());
        a[1] = Integer.parseInt(st.nextToken());
        a[2] = Integer.parseInt(st.nextToken());
        a[3] = Integer.parseInt(st.nextToken());
        String s = reader.readLine();
        long sum = 0;
        for (int i = 0; i < s.length(); i++) {
            sum+=(a[s.charAt(i)-'1']);
        }
        System.out.println(sum);
    }
}
