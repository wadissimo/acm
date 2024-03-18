package codeforces.alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class B {
    static boolean check(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        if (check(s)) {
            if(s.length() == 1){
                System.out.println(-1);

            } else
            if(s.length() ==2){
                System.out.println(1);
            } else if(s.length()%2 ==1) {
                System.out.println(s.length()/2+1);
            } else {
                System.out.println(-1);
            }
            return;
        }

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {

                String s1 = s.substring(0, i) + s.substring(i + 1);
                String s2;
                if (i != 0) {
                    s2 = s.substring(0, s.length() - 1 - i) + s.substring(s.length() - i);
                } else {
                    s2 = s.substring(0, s.length() - 1);
                }
                if (check(s1)) {
                    System.out.println(i+1);
                    return;
                } else if (check(s2)) {
                    System.out.println(s.length() - i);
                    return;
                }
            }
        }
        System.out.println(-1);

    }
}
