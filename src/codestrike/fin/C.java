package codestrike.fin;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by Vadim_2 on 23.04.2014.
 */
public class C {
    public static class P implements Comparable{
        int n;
        int d;
        //List<Integer> parties = new ArrayList<Integer>();
        Map<Integer, Integer> parties = new HashMap<Integer, Integer>();
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

        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());

            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ps[x-1].d++;
            Map<Integer, Integer> xps = ps[x - 1].parties;
            Integer yp = xps.get(y);
            if(yp == null) {
                yp = 1;
            } else {
                yp ++;
            }
            xps.put(y, yp);
            ps[y-1].d++;

            Map<Integer, Integer> yps = ps[y - 1].parties;
            Integer xp = yps.get(x);
            if(xp == null) {
                xp = 1;
            } else {
                xp ++;
            }
            yps.put(x, xp);
            pairs[i][0] = x;
            pairs[i][1] = y;

        }
        Arrays.sort(ps);



        int c = 0;
        for (int i = 0; i < ps.length; i++) {

            P pi = ps[i];
            if(pi.d >= p) {
                pi.npairs = n -i - 1;
            } else {
                for (int j = i + 1; j < n; j++) {
                   // c++;
                    P pj = ps[j];
                    if(pi.d + pj.d < p) {
                        break;
                    } else {
                        //remove pairs
                        int sum = pi.d + pj.d;
                        Integer nPairs = pi.parties.get(pj.n);
                        if(nPairs != null) {
                            sum -= nPairs;
                        }

//                        for (Integer party : pi.parties) {
//                            if(party.equals(pj.n)) {
//                                sum--;
//                            }
//                        }
                        if(sum >= p) {
                            pi.npairs ++;
                        }
                    }

                }
            }
        }

  //      System.out.println(Arrays.toString(ps));
        long ans = 0;
        for (int i = 0; i < n; i++) {
            ans += ((long)ps[i].npairs);
        }
        System.out.println(ans);
     //   System.out.println(c);
    }

}
