package codeforces.round242;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 *
 */
public class B {
    static class City implements Comparable{
        int x;
        int y;
        int k;
        double r;

        City(int x, int y, int k, double r) {
            this.x = x;
            this.y = y;
            this.k = k;
            this.r = r;
        }

        @Override
        public int compareTo(Object o) {
            return Double.compare(this.r, ((City)o).r);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        int s = Integer.parseInt(st.nextToken());
        City [] cs = new City[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int xi = Integer.parseInt(st.nextToken());
            int yi = Integer.parseInt(st.nextToken());
            int ki = Integer.parseInt(st.nextToken());
            cs[i] = new City(xi, yi, ki, Math.sqrt(xi*xi + yi*yi));
        }
        Arrays.sort(cs);
        long sum = s;
        for (int i = 0; i < n; i++) {
            sum += cs[i].k;
            if(sum >= 1000000) {
                System.out.println(cs[i].r);
                break;
            }
        }
        if(sum < 1000000) {
            System.out.println(-1);
        }
    }
}
