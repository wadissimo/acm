package codeforces.r243;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 *
 */
public class C {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }
        Integer res = Integer.MIN_VALUE;
        for (int l = 0; l < n; l++) {
            for (int r = l; r < n; r++) {
                PriorityQueue<Integer>  inter = new PriorityQueue<Integer>(200);
                PriorityQueue<Integer>  outer = new PriorityQueue<Integer>(200, Collections.reverseOrder());
                int f = 0;
                for (int i = 0; i < n; i++) {
                    if(i<l || i>r) {
                        outer.add(a[i]);
                    } else {
                        f += a[i];
                        inter.add(a[i]);
                    }
                }
                res = Math.max(res, f);
                for (int i = 0; i < k && !inter.isEmpty() && !outer.isEmpty(); i++) {
                    Integer intNum = inter.poll();
                    Integer outNum = outer.poll();
                    if(intNum < outNum) {
                        f += outNum - intNum;
                        res = Math.max(res, f);
                    }
                }
            }

        }


        System.out.println(res);

    }
}
