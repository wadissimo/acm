package codestrike.q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 11.05.2014.
 */
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int [][] a = new int[n][m];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                a[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int[] cache = new int[k];
        int [] whenLocked = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(whenLocked[j] != 0) {
                    continue;//ignore
                }
                if(a[j][i] == 0) {
                    continue;
                }
                if(cache[a[j][i]-1] == -1) {
                    whenLocked[j] = i + 1;
                } else if(cache[a[j][i]-1] == i + 1) {
                    //lock
                    cache[a[j][i]-1] = -1;
                    whenLocked[j] = i + 1;
                    for (int l = 0; l < n; l++) {
                        if(a[l][i] == a[j][i] && whenLocked[l] == 0) {
                            whenLocked[l] = i + 1;
                            break;
                        }
                    }
                } else {
                    cache[a[j][i]-1] = i + 1;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(whenLocked[i]);
        }
    }
}
