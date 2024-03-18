package codeforces.r238;

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
        int res = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            for (int j = 0; j < n; j++) {
                int a = Integer.parseInt(st.nextToken());
                if(i==j) {
                    if(a == 1){
                        res++;
                    }
                }
            }

        }
        res = res%2;
        st = new StringTokenizer(reader.readLine());
        int q = Integer.parseInt(st.nextToken());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(reader.readLine());
            int c = Integer.parseInt(st.nextToken());
            if(c == 1 || c ==2) {
                res = (res+1)%2;
            } else if(c ==3) {
                sb.append(res);
            }
        }
        System.out.println(sb);



    }
}
