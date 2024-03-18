package facebook.hackercup.year2017.r1;


import java.io.*;
import java.util.*;

/**
 * Created by Vadimka on 14.01.2017.
 */
public class A {
    static class Pair {
        int day;
        int num;

        public Pair(int day, int num) {
            this.day = day;
            this.num = num;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("c:/DEV/acm/tests/facebook/year2017/r1/pie_progress.txt"));
        BufferedWriter w = new BufferedWriter(new FileWriter("c:/DEV/acm/tests/facebook/year2017/r1/pie_progress_out.txt"));

        int t = Integer.parseInt(r.readLine()); // number of cycles
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(r.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            List<Integer> c[] = new List[n];
            for (int j = 0; j < n; j++) {
                st = new StringTokenizer(r.readLine());
                c[j] = new ArrayList<>(m);
                for (int k = 0; k < m; k++) {
                    c[j].add(Integer.parseInt(st.nextToken()));
                }
            }
            int tax[] = new int[n];
            for (int j = 0; j < n; j++) {
                tax[j] = 1;
            }
            int buys[] = new int[n];
            long ans = 0;
            for (int j = 0; j < n; j++) { // day
                int minPrice = Integer.MAX_VALUE;
                int dayMax = 0;
                int indMax = 0;
                for (int k = 0; k <= j; k++) { //days before
                    int l = 0;
                    for (Integer pie : c[k]) {
                        int price = pie + tax[k];
                        if(price < minPrice) {
                            minPrice = price;
                            dayMax = k;
                            indMax = l;
                        }
                        l++;
                    }
                }
                ans += minPrice;
                buys[dayMax] += 1;
                tax[dayMax] = (buys[dayMax]+1)*(buys[dayMax]+1) - buys[dayMax]*buys[dayMax];
               // System.out.println("day: " + dayMax + ", pie:" + c[dayMax].get(indMax) +", price: "+ minPrice);
                c[dayMax].remove(indMax);
            }
            w.write("Case #" + (i+1) + ": " + ans+"\n");



        }
        w.close();
    }
}
