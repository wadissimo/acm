package codeforces.r235;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 *
 */
public class B {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int x = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int maxd2 = 0;
        int mind2 = 0;
        int prev = 0;
        final int[] d2 = new int[k];
        int[] d1 = new int[k];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(reader.readLine());
            int type = Integer.parseInt(st.nextToken());

            if(type == 1) {
                d2[i] = Integer.parseInt(st.nextToken());
                d1[i] = Integer.parseInt(st.nextToken());
            } else {
                d2[i] = Integer.parseInt(st.nextToken());
            }

        }

        Integer[] ind = new Integer[k];
        for (int i = 0; i < k; i++) {
            ind[i] = i;
        }
        Arrays.sort(ind, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(d2[o1], d2[o2]);
            }
        });

        for (int i = 0; i < k; i++) {
            int num2 = d2[ind[i]];
            int num1 = d1[ind[i]];
            if(num2 - prev > 1) {
                maxd2 += num2 - prev-1;
                mind2 += (num2 - prev -1)/2 + (num2-prev-1)%2;
            }
            prev = num2;
            if(num1 != 0) {
                prev = num1;
            }

        }
        if(prev < x-1) {
            if(x - prev > 0) {
                maxd2 += (x - prev - 1);
                mind2 += (x-1 - prev)/2 + (x-1-prev)%2;
            }
        }



        System.out.println(mind2 + " " + maxd2);
    }
}
