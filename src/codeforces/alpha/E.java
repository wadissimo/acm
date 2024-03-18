package codeforces.alpha;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 */
public class E {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        StringBuilder sb = new StringBuilder();
        int shift = 'P' - 'H';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(c != ' ') {
                sb.append((char)('A' + ((c - 'A' + shift) % 26)));
            } else{
                sb.append(' ');
            }
        }

        System.out.println(sb);
    }
}
