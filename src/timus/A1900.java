package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 09.05.2014.
 */
public class A1900 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][]a = new int[n-1][n-1];
        int[][]b = new int[n-1][n-1];
        int[]current = new int[n-1];
        int[] total = new int[n-1];
        int [][]flow = new int[n-1][n-1];//from - to

        int totalCount = 0;
        for (int i = 0; i < n-1; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n - i - 1; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
                current[i] += a[i][j];
                for (int l = i; l <= i+j; l++) {
                    b[l][0] += a[i][j];
                }
            }
            totalCount += current[i];
            total[i] = totalCount;
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }


        int [][] d = new int[n][k+1];
        for (int i = 1; i < k; i++) {
            d[i-1][i] = total[i];
            b[i-1][i] = 0;
            for (int j = i; j < n-1; j++) {
                if(d[j-1][i] > d[j-1][i-1] + b[j-1][i-1]) {//don't turn on
                    d[j][i] = d[j-1][i];
                  //  b[j][i] =

                }


            }
        }

    }

    static void printArray(int[][] a) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                sb.append(a[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());

    }
}
