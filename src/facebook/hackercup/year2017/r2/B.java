package facebook.hackercup.year2017.r2;

import java.io.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.StringTokenizer;

/**
 * Created by Vadimka on 21.01.2017.
 */
public class B {

    static class Pole implements Comparable<Pole>{
        long x;
        long h;

        public Pole() {
        }

        public Pole(long x, long h) {
            this.x = x;
            this.h = h;
        }

        @Override
        public int compareTo(Pole o) {
            return Long.compare(x, o.x);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader r = new BufferedReader(new FileReader("c:/DEV/acm/tests/facebook/year2017/r2/big_top_example_input.txt"));
        BufferedWriter w = new BufferedWriter(new FileWriter("c:/DEV/acm/tests/facebook/year2017/r2/big_top_example_out.txt"));

        int t = Integer.parseInt(r.readLine()); // number of cycles
        for (int i = 0; i < t; i++) {
            int nn = Integer.parseInt(r.readLine());
            StringTokenizer st = new StringTokenizer(r.readLine());
            long x1 = Integer.parseInt(st.nextToken());
            long ax = Integer.parseInt(st.nextToken());
            long bx = Integer.parseInt(st.nextToken());
            long cx = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(r.readLine());
            long h1 = Integer.parseInt(st.nextToken());
            long ah = Integer.parseInt(st.nextToken());
            long bh = Integer.parseInt(st.nextToken());
            long ch = Integer.parseInt(st.nextToken());

            Pole[] pn = new Pole[nn];
            pn[0] = new Pole(x1, h1);

            for (int j = 1; j < nn; j++) {
                Pole pp = new Pole();
                pn[j] = pp;
                long m = BigInteger.valueOf(pn[j-1].x).multiply(BigInteger.valueOf(ax)).mod(BigInteger.valueOf(cx)).longValue();
                pp.x = (m + bx) % cx + 1;
                m = BigInteger.valueOf(pn[j-1].h).multiply(BigInteger.valueOf(ah)).mod(BigInteger.valueOf(ch)).longValue();
                pp.h = (m + bh) % ch + 1;
            }


            BigDecimal ans = BigDecimal.ZERO;
            for (int n = 1; n <= nn; n++) {
                Pole[] p = new Pole[n];
                System.arraycopy(pn, 0, p, 0, n);
                Arrays.sort(p);


                for (int j = 0; j < n; j++) {
                    if (p[j] == null) continue;
                    for (int k = 0; k < n; k++) {
                        if (p[k] == null || k == j) continue;
                        long dx = Math.abs(p[k].x - p[j].x);

                        if (p[k].h < p[j].h - dx) {
                            p[k] = null;
                        }
                    }
                }

                LinkedList<Pole> list = new LinkedList<Pole>();
                for (int j = 0; j < n; j++) {

                    if (p[j] != null) {
                        list.add(p[j]);
                    }
                }

                Pole prev = null;
                if (list.size() > 1) {
                    for (Pole pole : list) {
                        if (prev != null) {
                            long dx = pole.x - prev.x;
                            long dh = Math.abs(pole.h - prev.h);
                            double hmid;
                            double xmid;
                            if (dh >= 0) {
                                xmid = prev.x + (dx - dh) / 2.0;
                                hmid = prev.h - (xmid - prev.x);
                            } else {
                                xmid = pole.x - (dx - dh) / 2.0;
                                hmid = pole.h - (pole.x - xmid);
                            }
                            ans = ans.add(BigDecimal.valueOf(hmid).multiply(BigDecimal.valueOf(dx)))
                                    .add(BigDecimal.valueOf(prev.h - hmid).pow(2).divide(BigDecimal.valueOf(2), 10, BigDecimal.ROUND_HALF_UP))
                                    .add(BigDecimal.valueOf(pole.h - hmid).pow(2).divide(BigDecimal.valueOf(2), 10, BigDecimal.ROUND_HALF_UP));

                        }
                        prev = pole;
                    }
                }
//add first
                Pole first = list.getFirst();
                Pole last = list.getLast();
                if (first.x < first.h) {
                    ans = ans.add(BigDecimal.valueOf(first.x).pow(2).divide(BigDecimal.valueOf(2), 10, BigDecimal.ROUND_HALF_UP));
                    ans = ans.add(BigDecimal.valueOf(first.h - first.x).multiply(BigDecimal.valueOf(first.x)));
                } else {
                    ans = ans.add(BigDecimal.valueOf(first.h).pow(2).divide(BigDecimal.valueOf(2), 10, BigDecimal.ROUND_HALF_UP));
                }
                ans = ans.add(BigDecimal.valueOf(last.h).pow(2).divide(BigDecimal.valueOf(2), 10, BigDecimal.ROUND_HALF_UP));
            }
            w.write("Case #" + (i+1) + ": " + ans + "\n");


        }
        w.close();
    }
}
