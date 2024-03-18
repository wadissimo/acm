package codeforces.r247;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Created by Vadim
 */
public class B {
    static long max = 0;
    static long getHappy (int[] a, int[][]g) {
        long res = g[a[0]-1][a[1]-1]+g[a[1]-1][a[0]-1]+g[a[2]-1][a[3]-1]+g[a[3]-1][a[2]-1]+
                g[a[1]-1][a[2]-1]+g[a[2]-1][a[1]-1]+g[a[3]-1][a[4]-1]+g[a[4]-1][a[3]-1]+
                g[a[2]-1][a[3]-1]+g[a[3]-1][a[2]-1] +
                g[a[3]-1][a[4]-1]+g[a[4]-1][a[3]-1];
        return res;
    }
    static void getMax(int[] a, int g[][], int l) {
        for (int i = 0; i < 5; i++) {
            if(a[i] == 0) {
                a[i] = l;
                if(l < 5) {
                    getMax(a, g, l + 1);
                } else if(l == 5) {
                    long happy = getHappy(a, g);
                    max = Math.max(max, happy);
                }
                a[i] = 0;
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int[][]g = new int[5][5];
        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < 5; j++) {
                g[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        getMax(new int[5], g, 1);
        System.out.println(max);



    }
}
