package codeforces.r243;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class D {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        //make rows <= columns
        if(n>m){
            int t = n;
            n = m;
            m = t;
            int[][] b = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    b[i][j] = a[j][i];
                }
            }
             a = b;
        }
        if(n <= 20) {
            //use mask to solve
            int cols[] =  new int[m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    cols[i]+=a[j][i]<<j;
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 1 << n; i++) {
                int count = 0;
                for (int j = 0; j < m; j++) {
                    int bits = Integer.bitCount(i ^ cols[j]);
                    count += Math.min(bits, n-bits);
                }
                if(count < min) {
                    min = count;
                }
            }
            if(min<=k ){
                System.out.println(min);
            } else {
                System.out.println(-1);
            }
        } else {
            int[] errors = new int[n];
            int errorsc = 0;
            for (int i = 1; i < m; i++) {
                int d = 0;
                for (int j = 0; j < n; j++) {
                    if(a[j][i] != a[j][i-1]) {
                        i++;
                    }
                }
                boolean change = n-d < d;
                for (int j = 0; j < n; j++) {
                    if(change && a[j][i] == a[j][i-1]) {
                        if(errors[j] == 0) {
                            errors[j] ++;
                            errorsc++;
                       }

                    } else if(!change && a[j][i] != a[j][i-1]){
                        if(errors[j] == 0) {
                            errors[j] ++;
                            errorsc++;
                        }
                    }
                }
            }
            int [][] b = new int[errorsc][m];
            int bi = 0;
            for (int i = 0; i < n; i++) {
                if(errors[i] != 0) {
                    System.arraycopy(a[i], 0, b[bi], 0, m);
                    bi++;
                }
            }
            int cols[] =  new int[m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < b.length; j++) {
                    cols[i]+=b[j][i]<<j;
                }
            }
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < 1 << b.length; i++) {
                int count = 0;
                for (int j = 0; j < m; j++) {
                    int bits = Integer.bitCount(i ^ cols[j]);
                    count += Math.min(bits, b.length-bits);
                }
                if(count < min) {
                    min = count;
                }
            }
            if(min<=k ){
                System.out.println(min);
            } else {
                System.out.println(-1);
            }
        }


    }
}
