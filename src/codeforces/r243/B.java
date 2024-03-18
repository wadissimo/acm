package codeforces.r243;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class B {
    static int test(int[][] a, int mid) {
        for (int i = 0; i < mid; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if(a[i][j] != a[mid*2-i-1][j]){
                    return mid*2;
                }
            }
        }
        if(mid%2 ==1) {
            return mid;
        }
        return test(a, mid/2);

    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(n%2 == 1) {
            System.out.println(n);
        } else {
            System.out.println(test(a, n/2));
        }
    }
}
