package codeforces.r237;

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
        char o = 0;
        char d = 0;
        boolean ans = true;
        for (int i = 0; i < n; i++) {
            String s = reader.readLine();
            for (int j = 0; j < n; j++) {
                char c = s.charAt(j);
                if(i == j || n-i-1 == j) {
                    if(d == 0) {
                        d = c;
                    } else {
                        if(d != c) {
                            ans = false;
                        }
                    }
                } else {
                    if(c == d) {
                        ans = false;
                    }
                    if(o == 0) {
                        o = c;
                    } else {
                        if(o != c) {
                            ans = false;
                        }
                    }
                }
            }
        }
        if (ans) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }


        
    }
}
