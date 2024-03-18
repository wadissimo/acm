package codeforces.round242;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */
public class D {
    static int[][] f;
    static int tp;
    static int tu;
    static int td;
    static int time(int i0, int j0, int i1, int j1) {
        int next = f[i1][j1];
        int prev = f[i0][j0];
        if(prev == next) {
            return tp;
        } else if(next > prev) {
            return tu;
        } else {
            return td;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        long t = Long.parseLong(st.nextToken());
        st = new StringTokenizer(reader.readLine());

        tp = Integer.parseInt(st.nextToken());

        tu = Integer.parseInt(st.nextToken());

        td = Integer.parseInt(st.nextToken());

        f = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                f[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // calc distances : horizontal and vertical (including reverse)
        int[][] lenh = new int[n][m];
        int[][] lenhr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int k = 2; k < m + 1; k++) {
                lenh[i][k-1] = lenh[i][k - 2] + time(i, k - 2, i, k - 1);
                lenhr[i][k-1] = lenhr[i][k - 2] + time(i, k - 1, i, k - 2);
            }
        }
        int[][] lenv = new int[m][n];
        int[][] lenvr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int k = 2; k < n + 1; k++) {
                lenv[i][k-1] = lenv[i][k - 2] + time(k - 2, i, k - 1, i);
                lenvr[i][k-1] = lenvr[i][k - 2] + time(k - 1, i, k - 2, i);
            }
        }

        //all possible rects
        long min = Long.MAX_VALUE;
        int minx1 = 0;
        int miny1 = 0;
        int minx2 = 0;
        int miny2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 3; k < m - j + 1 ; k++) {
                    int h = lenh[i][j + k - 1] - lenh[i][j];
                    for (int l = 3; l < n - i + 1; l++) {
                        int ts = h + lenv[j + k - 1][i+l-1] - lenv[j + k -1][i]
                                + lenhr[i+l-1][j+k-1] - lenhr[i][j]
                                + lenvr[j][i+l-1] - lenvr[j][i] ;
                        if(Math.abs(t - ts)< min) {
                            min = Math.abs(t - ts);
                            minx1 = i+1;
                            miny1 = j+1;
                            minx2 = i+l;
                            miny2 = j+k;
                        }
                    }
                }
            }
        }
        System.out.println(minx1+ " " + miny1 + " " + minx2 + " " + miny2);

        //System.out.println(min);
    }
}
