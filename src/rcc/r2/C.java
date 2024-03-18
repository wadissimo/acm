package rcc.r2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 18.05.2014.
 */
public class C {
    static int square(int w, int h) {
        if(w > 0 && h>0) {
            if (w < h) {
                h=w;
            }
            return w * (w + 1) / 2 - (w - h) * (w - h + 1) / 2;
        }else {
            return 0;
        }

    }
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            int[] res = new int[8];
            res[0] = square(m-y-1, n-x);
            res[1] = square(n-x-1, m-y);
            res[2] = square(y-2, n-x);
            res[3] = square(n-x-1, y-1);
            res[4] = square(y-2, x-1);
            res[5] = square(x-2, y-1);
            res[6] = square(x-2, m-y);
            res[7] = square(m-y-1, x-1);
            int ans = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < 8; j++) {
                if(res[j]!=0) {
                    ans++;
                    sb.append(res[j]).append(" ");
                }
            }
            if(ans == 0) {
                System.out.println(0);
            }else {
                System.out.println(ans+ " " + sb);
            }


        }
    }

}
