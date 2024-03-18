package codeforces.round242;

import java.util.Random;

/**
 *
 */
public class DGen {
    public static void main(String[] args) {
        Random r = new Random();
        for (int i = 0; i < 300; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 300; j++) {
                sb.append(r.nextInt(1000)).append(" ");
            }
            System.out.println(sb);
        }
    }
}
