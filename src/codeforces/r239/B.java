package codeforces.r239;

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
        String s = reader.readLine();
        String p = reader.readLine();
        int[] sc = new int[26];
        int[] pc = new int[26];
        for (int i = 0; i < s.length(); i++) {
            sc [s.charAt(i) - 'a']++;
        }
        boolean check = false;
        for (int i = 0; i < p.length(); i++) {
            if(sc[p.charAt(i) - 'a'] == 0) {
                check = true;
                break;
            }
            pc [p.charAt(i) - 'a']++;
        }
        if(check) {
            System.out.println(-1);
        } else {
            int sum = 0;
            for (int i = 0; i < 26; i++) {
                sum += Math.min(sc[i], pc[i]);
            }
            System.out.println(sum);
        }
    }
}
