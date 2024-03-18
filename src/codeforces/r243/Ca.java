package codeforces.r243;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */
public class Ca {
    static void swap (int[]a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    static int getMax(int[]a) {
        int[][] f = getF(a);
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if(f[i][j] > max) {
                    max = f[i][j];
                }
            }
        }
        return max;
    }

    static int[][] getF(int[] a) {
        int[][] res = new int[a.length][a.length];
        for (int i = 0; i < a.length; i++) {
            for (int j = i; j < a.length; j++) {
                if(j == i) {
                    res[i][j] = a[i];
                } else {
                    res[i][j] = res[i][j - 1] + a[j];
                }
            }
        }
        return res;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        int[][] f = getF(a);
        int maxF = Integer.MIN_VALUE;
        int l = 0;
        int r = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if(f[i][j] > maxF) {
                    maxF = f[i][j];
                    l = i;
                    r = j;
                }
            }
        }

        for (int i = 0; i < k; i++) {

            //find min
            for (int jk = 0; jk < n; jk++) {

                int maxVal = maxF;
                int x = -1;
                int y = -1;
                for (int j = 0; j < n; j++) {
                    if (j != jk) {
                        swap(a, jk, j);
                        int max1 = getMax(a);
                        if (max1 > maxVal) {
                            x = jk;
                            y = j;
                            maxVal = max1;
                        }
                        swap(a, jk, j);
                    }
                }


                if (x != -1) {
                    swap(a, x, y);
                    f = getF(a);
                    maxF = Integer.MIN_VALUE;
                    l = 0;
                    r = 0;
                    for (int m = 0; m < n; m++) {
                        for (int t = m; t < n; t++) {
                            if (f[m][t] > maxF) {
                                maxF = f[m][t];
                                l = m;
                                r = t;
                            }
                        }
                    }

                } else {
                    break;
                }
            }
        }

        System.out.println(maxF);


    }

}
