package codeforces.round242;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class Da {

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
        long t1 = System.currentTimeMillis();
        int[][][] lenh = new int[n][m][];
        int[][][] lenhr = new int[n][m][];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                lenh[i][j] =  new int[m-j];
                lenhr[i][j] =  new int[m-j];
                if(j != m-1) {
                    if (j == 0) {
                        for (int k = 1; k < m - j; k++) {
                            lenh[i][j][k] = lenh[i][j][k - 1] + time(i, j + k - 1, i, j + k);
                            lenhr[i][j][k] = lenhr[i][j][k - 1] + time(i, j + k, i, j + k - 1);
                        }
                    } else {
                        int timef = time(i, j - 1, i, j);
                        int timefr = time(i, j, i, j - 1);
                        for (int k = 1; k < m - j; k++) {
                            lenh[i][j][k] = lenh[i][j - 1][k + 1] - timef;
                            lenhr[i][j][k] = lenhr[i][j - 1][k + 1] - timefr;
                        }
                    }
                }
            }
        }
        long t2 = System.currentTimeMillis();
        System.out.println(t2-t1);

        int[][][] lenv = new int[n][m][];
        int[][][] lenvr = new int[n][m][];

        for (int j = 0; j < m; j++) {
            for (int i = 0; i < n; i++) {
                lenv[i][j] =  new int[n-i];
                lenvr[i][j] =  new int[n-i];
                if(i != n-1) {
                    if (i == 0) {
                        for (int k = 1; k < n - i; k++) {
                            lenv[i][j][k] = lenv[i][j][k - 1] + time(i + k - 1, j, i + k, j);
                            lenvr[i][j][k] = lenvr[i][j][k - 1] + time(i + k, j, i + k - 1, j);
                        }
                    } else {
                        int timef = time(i - 1, j, i, j);
                        int timefr = time(i, j, i - 1, j);
                        for (int k = 1; k < n - i; k++) {
                            lenv[i][j][k] = lenv[i - 1][j][k + 1] - timef;
                            lenvr[i][j][k] = lenvr[i - 1][j][k + 1] - timefr;
                        }
                    }
                }
            }
        }
        long t3 = System.currentTimeMillis();
        System.out.println(t3-t2);

        long min = Long.MAX_VALUE;
        int minx1 = 0;
        int miny1 = 0;
        int minx2 = 0;
        int miny2 = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                for (int k = 3; k < m - j + 1 ; k++) {
                    int h = lenh[i][j][k - 1];
                    for (int l = 3; l < n - i + 1; l++) {
                        int ts = h + lenv[i][j + k -1][l-1] + lenhr[i + l - 1][j][k - 1] + lenvr[i][j][l-1];
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
        long t4 = System.currentTimeMillis();
        System.out.println(t4-t3);
        System.out.println(minx1+ " " + miny1 + " " + minx2 + " " + miny2);

    }
}
