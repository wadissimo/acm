package codeforces.codestrikefinal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 *
 */
public class Da {
    public static class P implements Comparable{
        int n;
        int d;
        List<Integer> parties = new ArrayList<Integer>();
        int npairs;

        public P(int n, int d) {
            this.n = n;
            this.d = d;
        }

        @Override
        public int compareTo(Object o) {
            //sort descending
            return -Integer.compare(this.d, ((P)o).d);
        }

        @Override
        public String toString() {
            return "P{" +
                    "n=" + n +
                    ", d=" + d +
                    ", parties=" + parties +
                    ", npairs=" + npairs +
                    '}';
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(reader.readLine());


        int n = Integer.parseInt(st.nextToken());

        int p = Integer.parseInt(st.nextToken());
        P[] ps = new P[n];
        for (int i = 0; i < ps.length; i++) {
            ps[i] = new P(i + 1, 0);
        }

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ps[x-1].d++;
            ps[x-1].parties.add(y);
            ps[y-1].d++;
            ps[y-1].parties.add(x);
        }
        Arrays.sort(ps);


        for (int i = 0; i < ps.length; i++) {
            P pi = ps[i];
            if(pi.d >= p) {
                pi.npairs = n -i - 1;
            } else {
                //binary
                for (int j = i + 1; j < n; j++) {
                    P pj = ps[j];
                    if(pi.d + pj.d < p) {
                        break;
                    } else {
                        //remove pairs
                        int sum = pi.d + pj.d;

                        for (Integer party : pi.parties) {
                            if(party.equals(pj.n)) {
                                sum--;
                            }
                        }
                        if(sum >= p) {
                            pi.npairs ++;
                        }
                    }

                }
            }
        }
        //System.out.println(Arrays.toString(ps));
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += ((long)ps[i].npairs);
        }
        System.out.println(ans);

    }
}
