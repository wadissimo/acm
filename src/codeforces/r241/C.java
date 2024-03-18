package codeforces.r241;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 *
 */
public class C {
    static class Order implements Comparable{

        int n;
        int c;
        int p;
        boolean accepted;

        Order(int n, int c, int p) {
            this.n = n;
            this.c = c;
            this.p = p;
        }

        @Override
        public int compareTo(Object o) {
            return -Integer.compare(this.p, ((Order)o).p);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());

        Order[] orders = new Order[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int ci = Integer.parseInt(st.nextToken());
            int pi = Integer.parseInt(st.nextToken());
            orders[i] = new Order(i + 1, ci, pi);
        }
        st = new StringTokenizer(reader.readLine());
        int k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(reader.readLine());
        final Integer[] r = new Integer[k];
        final Integer[] rind = new Integer[k];
        for (int i = 0; i < k; i++) {
            int ri = Integer.parseInt(st.nextToken());
            rind[i] = i;
            r[i] = ri;
        }
        Arrays.sort(rind, new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                return Integer.compare(r[o1], r[o2]);
            }
        });
        Arrays.sort(orders);
        Order[] accepted = new Order[k];
        int m = 0;
        int s = 0;
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                if(!orders[j].accepted && orders[j].c <= r[rind[i]]) {
                    accepted[rind[i]] = orders[j];
                    orders[j].accepted = true;
                    m++;
                    s += orders[j].p;
                    break;
                }
            }
        }
        System.out.println(m + " "+ s);
        for (int i = 0; i < k; i++) {
            if(accepted[i] != null) {
                System.out.println(accepted[i].n + " " + (i + 1));


            }
        }

    }
}
