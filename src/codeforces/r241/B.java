package codeforces.r241;

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
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        long [][] t = new long[n][m];
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                t[j][i] = Long.parseLong(st.nextToken());
            }
        }
        long [][] time = new long[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(i == 0) {
                    if(j == 0) {
                        time[i][j] = t[i][j];
                    }else {
                        time[i][j] = time[i][j-1] + t[i][j];
                    }

                } else {
                    if(j == 0) {
                        time[i][j] = time[i-1][j] + t[i][j];
                    } else {
                        time[i][j] = Math.max(time[i][j - 1], time[i - 1][j]) + t[i][j];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            sb.append(time[n-1][i]).append(" ");
        }
        System.out.println(sb);

    }
}
