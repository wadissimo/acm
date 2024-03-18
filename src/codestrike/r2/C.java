package codestrike.r2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Vadim_2 on 10.05.2014.
 */
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[] price = new int[n];

        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        List<Integer> aucPrice = new ArrayList<Integer>(m);
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < m; i++) {
            int x = Integer.parseInt(st.nextToken());
            aucPrice.add(price[x-1]);
            price[x-1] = 0;
        }
        long points = 0;

        for (int i = 0; i < n; i++) {
            points += price[i];
        }
        Collections.sort(aucPrice, Collections.reverseOrder());


        for (Iterator<Integer> it = aucPrice.iterator(); it.hasNext(); ) {
            Integer aucpoints = it.next();
            if (aucpoints < points) {
                points += points;
            } else {
                points += aucpoints;
            }
        }


        System.out.println(points);


    }
}
