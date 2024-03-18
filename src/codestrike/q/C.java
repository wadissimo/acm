package codestrike.q;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Created by Vadim_2 on 11.05.2014.
 */
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int p11d = Integer.parseInt(st.nextToken());
        int p11a = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int p12d = Integer.parseInt(st.nextToken());
        int p12a = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int p21d = Integer.parseInt(st.nextToken());
        int p21a = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int p22d = Integer.parseInt(st.nextToken());
        int p22a = Integer.parseInt(st.nextToken());
        boolean case1 = p11a > p21d && p12d > p22a;
        boolean case2 = p12a > p21d && p11d > p22a;
        boolean case3 = p11a > p22d && p12d > p21a;
        boolean case4 = p12a > p22d && p11d > p21a;

        boolean case1a = p11a < p21d && p12d < p22a;
        boolean case2a = p12a < p21d && p11d < p22a;
        boolean case3a = p11a < p22d && p12d < p21a;
        boolean case4a = p12a < p22d && p11d < p21a;

        if(case1 && case3 || case2 && case4) {
            System.out.println("Team 1");
        } else
        if((case1a || case3a) && (case2a || case4a)) {
            System.out.println("Team 2");
        } else {
            System.out.println("Draw");
        }



    }
}
