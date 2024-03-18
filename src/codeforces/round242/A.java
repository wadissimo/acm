package codeforces.round242;

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
        String s =reader.readLine();
        int sit = 0;
        int stand = 0;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if(c == 'x') sit ++;
            if(c=='X') stand++;
        }
        int dif = stand - sit;
        int ans = Math.abs(dif)/2;
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i <n; i++) {
            char c = s.charAt(i);
            if(dif == 0) {
                sb.append(c);
            }else if(dif < 0 && c == 'x') {
                sb.append('X');
                dif+=2;
            } else if( dif > 0 && c == 'X') {
                sb.append('x');
                dif-=2;
            } else {
                sb.append(c);
            }
        }
        System.out.println(ans);
        System.out.println(sb);



    }

}
