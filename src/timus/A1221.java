package timus;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 06.05.2014.
 */
public class A1221 {
    static boolean check(int y, int x, int[][] a, int[][] l, int size) {
        for (int i = 0 ; i < size; i++) {
            if(i < size/2 &&
                    (l[y+i][x+size/2-i-1] < size/2-i || a[y+i][x+size/2-i-1] != 1 ||
                    l[y+i][x+size/2+i] != 2*i + 1 || a[y+i][x+size/2+i] != 0 ||
                    l[y+i][x+size-1] != size/2-i || a[y+i][x+size-1] != 1)){
                return false;
            } else if(i > size/2 &&
                    (l[y+i][x+i-size/2-1] < i-size/2 || a[y+i][x+i-size/2-1] != 1 ||
                            l[y+i][x + size - (i-size/2) - 1] != 2*(size - i) - 1 || a[y+i][x + size - (i-size/2) - 1] != 0 ||
                            l[y+i][x+size-1] != i-size/2 || a[y+i][x+size-1] != 1)) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = -1;
        while (n!=0) {
            StringTokenizer st = new StringTokenizer(reader.readLine());
            n = Integer.parseInt(st.nextToken());
            if(n == 0) {
                break;
            }
            int[][] a = new int[n][n];
            int[][] l = new int[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(reader.readLine());
                for (int j = 0; j < n; j++) {
                    a[i][j] = Integer.parseInt(st.nextToken());
                    if (j > 0 && a[i][j - 1] == a[i][j]) {
                        l[i][j] = l[i][j - 1] + 1;
                    } else {
                        l[i][j] = 1;
                    }
                }
            }
            if (n < 3) {
                System.out.println("No solution");
                continue;
            }

            int maxSize = 0;
            for (int j = n - 1; j > 1; j--) {
                for (int i = 1; i < n - 1; i++) {
                    if (a[i][j] == 0 && a[i - 1][j] == 1 && a[i + 1][j] == 1 && l[i][j] >= 3) {
                        if (a[i - 1][j - 1] == a[i + 1][j - 1] && a[i + 1][j - 1] == 0) {
                            if (l[i - 1][j - 1] == l[i + 1][j - 1] && l[i - 1][j - 1] < l[i][j - 1]) {
                                int size = l[i - 1][j - 1] + 2;
                                if (size % 2 == 1 && size > maxSize && i - size / 2 >= 0 && i + size / 2 < n) {
                                    if (check(i - size / 2, j - size + 1, a, l, size)) {
                                        maxSize = size;
                                    }
                                }
                            }

                        }
                    }

                }

            }
            if (maxSize > 0) {
                System.out.println(maxSize);
            } else {
                System.out.println("No solution");
            }
        }


    }

}
