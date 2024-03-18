package rcc.r2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 18.05.2014.
 */
public class B {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int T = Integer.parseInt(st.nextToken());
        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(reader.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            k += 3;
            if(n==1 && m < 3 || m == 1 && n < 3) {
                System.out.println("IMPOSSIBLE");
            }else {

                    if(n >=3 && k == n + (m - 1) * 3) {
                        System.out.println("1 1 2 1 3 1");
                    } else if(m >=3 && k == m + (n - 1) * 3) {
                        System.out.println("1 1 1 2 1 3");
                    } else  if(m >=2 && n >= 2 && k == n + (m - 1) + n-1 + m-2 ) {
                        System.out.println("1 1 2 1 1 2");
                    } else if(n >=3 && m>=2 && k == n + (m - 1) + m-1 + m-1 +n-3) {
                        System.out.println("1 1 2 1 3 2");
                    } else if(n >=2 && m>=3 && k == m + (n - 1) + n-1 + n-1 +m-3) {
                        System.out.println("1 1 1 2 2 3");
                    } else if(n >=2 && m>=2 && k == n + (m - 1) + m-1 +n-2) {
                        System.out.println("1 1 2 1 2 2");
                    } else if(n >=2 && m>=2 && k == m + (n - 1) + n-1 +m-2) {
                        System.out.println("1 1 1 2 2 2");
                    } else if(n >=3 && m>=3 && k == n + (m - 1) + m-1 +n-2 + m-2 + n-3) {
                        System.out.println("1 1 2 2 3 3");
                    } else  {
                        System.out.println("IMPOSSIBLE");
                    }

            }
        }



    }
}
