package codeforces.r235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        if(2*n<m-2) {
            System.out.println(-1);
        } else if(2*n<=m) {
            for (int i = 0; i < n; i++) {
                sb.append("110");
            }
            if(2*n == m-2){
                sb.append("11");
            }else if(2*n == m-1){
                sb.append("1");
            }
            System.out.println(sb);
        } else if(n> m + 1){
            System.out.println(-1);
        } else {
            if(n == m+1){
                sb.append("0");
                n--;
            }
            for (int i = 0; i < n; i++) {
                if(i < m-n) {
                    sb.append("110");
                } else {
                    sb.append("10");
                }
            }
            System.out.println(sb);
        }

    }
}
