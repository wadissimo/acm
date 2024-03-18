package codeforces.bubble11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *
 */
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int rating[]=new int[n-1];
        int points[]=new int[n-1];
        st = new StringTokenizer(reader.readLine());
        int max_points=0;
        int ri=0;
        if(n == 1){
            st = new StringTokenizer(reader.readLine());
            System.out.println(1);
        }else {
            for (int i = 0; i < n; i++) {
                if (i == d - 1)
                    max_points += Integer.parseInt(st.nextToken());
                else
                    rating[ri++] = Integer.parseInt(st.nextToken());
            }
            st = new StringTokenizer(reader.readLine());
            max_points += Integer.parseInt(st.nextToken());
            ri = 0;
            for (int i = 0; i < n - 1; i++) {
                points[ri++] = Integer.parseInt(st.nextToken());
            }

            int l = 0;
            int r = d - 1;
            while (l < r) {
                int m = (l + r) / 2;
                ri = n - 2;
                boolean possible = true;
                for (int i = m; i < n - 1; i++) {
                    if (rating[i] + points[ri--] > max_points) {
                        possible = false;
                        break;
                    }
                }
                if (possible) {
                    r = m;
                } else {
                    l = m + 1;
                }
            }
            System.out.println(l + 1);
        }
    }
}
