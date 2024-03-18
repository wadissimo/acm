package codeforces.codestrikefinal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/**
 *
 */
public class D {
    public static class P implements Comparable{
        int n;
        int d;


        public P(int n, int d) {
            this.n = n;
            this.d = d;
        }

        @Override
        public int compareTo(Object o) {
            //sort descending
            return -Integer.compare(this.d, ((P)o).d);
        }


    }
    private static class Pair {
        P a;
        P b;

        private Pair(P a, P b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Pair pair = (Pair) o;

            if (!a.equals(pair.a)) return false;
            if (!b.equals(pair.b)) return false;

            return true;
        }

        @Override
        public int hashCode() {
            int result = a.n;
            result = 31 * result + b.n;
            return result;
        }
    }

    public static final int MASK = (1<<20)-1;
    private static long code(int a, int b) {
        return (a<<20)|b;
    }
    private static int[] decode(long code) {
        return new int[] {(int)(code>>20), (int)(code&MASK)};
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

        Map<Long, Integer> pairs = new HashMap<Long, Integer>();
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            ps[x-1].d++;
            ps[y-1].d++;
            //Pair pair;
            long pair;
            if(x > y) {
                pair = code(x, y);
            } else {
                pair = code(y, x);
            }
            Integer pc = pairs.get(pair);
            if(pc == null) {
                pc = 0;
            }
            pairs.put(pair, pc + 1);
//            if(x > y) {
//                pair = new Pair(ps[x-1], ps[y-1]);
//            } else {
//                pair = new Pair(ps[y-1], ps[x-1]);
//            }
//            if(pairs.containsKey(pair)) {
//                pairs.put(pair, pairs.get(pair) + 1);
//            } else {
//                pairs.put(pair, 1);
//            }
        }
        P[] pns = new P[n];
        System.arraycopy(ps, 0, pns, 0, n);
        Arrays.sort(ps);
        long ans = 0;

        for (int i = 0; i < n; i++) {
            P pi = ps[i];
            if(pi.d >= p) {
                ans += n - i - 1;
            } else {
                //todo: binary
                int left = i + 1;
                int right = n;
                while (left < right) {
                    int j = (right + left) / 2;
                    P pj = ps[j];
                    if (pi.d + pj.d >= p) {
                        left = j + 1;
                    } else {
                        right = j;
                    }

                }
                ans += right - i - 1;
                if(right == i + 1) {
                    break;
                }

            }
        }

//        for (int i = 0; i < n; i++) {
//            ans += ((long)ps[i].npairs);
//        }

        for (Map.Entry<Long, Integer> e : pairs.entrySet()) {
            Long key = e.getKey();
            int[] ab = decode(key);
            int a = ab[0];
            int b = ab[1];
            if(pns[a-1].d + pns[b-1].d >= p && pns[a-1].d + pns[b-1].d - e.getValue() < p) {
                ans --;
            }
        }

        //      System.out.println(Arrays.toString(ps));

        System.out.println(ans);
    }

}
