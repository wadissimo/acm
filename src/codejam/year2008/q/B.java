package codejam.year2008.q;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.*;

public class B {
    class Leg{
        int from, to;
        int station;
        public Leg(String s, int station) {
            this.station = station;
            StringTokenizer st = new StringTokenizer(s, ": ");
            from = 60*Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
            to = 60*Integer.parseInt(st.nextToken()) + Integer.parseInt(st.nextToken());
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int wait = in.ni();
            int na = in.ni();int nb = in.ni();
            ArrayList<Leg> legs = new ArrayList<>();
            for (int i = 0; i < na; i++) {
                legs.add(new Leg(in.readLine(), 0));
            }
            for (int i = 0; i < nb; i++) {
                legs.add(new Leg(in.readLine(), 1));
            }
            legs.sort(Comparator.comparingInt(a -> a.from));
            PriorityQueue<Integer>[] pool = new PriorityQueue[]{new PriorityQueue(), new PriorityQueue()};
            int[] ans = new int[2];
            for (Leg leg : legs) {
                if(!pool[leg.station].isEmpty() && pool[leg.station].peek() <= leg.from){
                    pool[leg.station].poll();
                } else {
                    ans[leg.station]++;
                }
                pool[1-leg.station].offer(leg.to+wait);
            }
            out.printf("Case #%d: %d %d%n",t+1, ans[0], ans[1]);
        }
    }
}
