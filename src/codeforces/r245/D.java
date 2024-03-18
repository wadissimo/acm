package codeforces.r245;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 14.05.2014.
 */
public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int [][]a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        long m1[][] = new long[n][m];
        m1[0][0] = a[0][0];
        for (int i = 1; i < m; i++) {
            m1[0][i] = m1[0][i-1]+a[0][i];
        }
        for (int i = 1; i < n; i++) {
            m1[i][0] = m1[i-1][0]+a[i][0];
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                m1[i][j] = a[i][j] + Math.max(m1[i-1][j], m1[i][j-1]);
            }
        }

        long w1[][] = new long[n][m];
        w1[n-1][0] = a[n-1][0];
        for (int i = 1; i < m; i++) {
            w1[n-1][i] = w1[n-1][i-1]+a[n-1][i];
        }
        for (int i = n-2; i >=0; i--) {
            w1[i][0] = w1[i+1][0]+a[i][0];
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = 1; j < m; j++) {
                w1[i][j] = a[i][j] + Math.max(w1[i+1][j], w1[i][j-1]);
            }
        }

        long m2[][] = new long[n][m];
        m2[n-1][m-1] = a[n-1][m-1];
        for (int i = m-2; i >= 0; i--) {
            m2[n-1][i] = m2[n-1][i+1]+a[n-1][i];
        }
        for (int i = n-2; i >=0; i--) {
            m2[i][m-1] = m2[i+1][m-1]+a[i][m-1];
        }
        for (int i = n-2; i >= 0; i--) {
            for (int j = m-2; j >= 0; j--) {
                m2[i][j] = a[i][j] + Math.max(m2[i+1][j], m2[i][j+1]);
            }
        }

        long w2[][] = new long[n][m];
        w2[0][m-1] = a[0][m-1];
        for (int i = m-2; i >= 0; i--) {
            w2[0][i] = w2[0][i+1]+a[0][i];
        }
        for (int i = 1; i < n; i++) {
            w2[i][m-1] = w2[i-1][m-1]+a[i][m-1];
        }
        for (int i = 1; i < n; i++) {
            for (int j = m-2; j >= 0; j--) {
                w2[i][j] = a[i][j] + Math.max(w2[i-1][j], w2[i][j+1]);
            }
        }

        long res = -1;
        for (int i = 1; i < n-1; i++) {
            for (int j = 1; j < m-1; j++) {
                res = Math.max(res, Math.max(m1[i][j-1]+w1[i+1][j]+m2[i][j+1]+w2[i-1][j], m1[i-1][j] + w1[i][j-1]+ m2[i+1][j] + w2[i][j+1]));
            }
        }
        System.out.println(res);


    }
}
