package codeforces.r478;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class D {
    class Pair implements Comparable<Pair>{
        long c;
        int vx;

        public Pair(long c, int vx) {
            this.c = c;
            this.vx = vx;
        }

        @Override
        public int compareTo(Pair o) {
            if(this.c == o.c)
                return Integer.compare(this.vx, o.vx);
            else
                return Long.compare(this.c, o.c);
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), a = in.ni(), b = in.ni();
        TreeMap<Pair, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int x = in.ni(), vx = in.ni(), vy = in.ni();
            long c = vy - a*(long)vx;
            Pair p = new Pair(c, vx);
            map.put(p, map.getOrDefault(p, 0)+1);
        }
        long ans = 0;
        long cnt = 0;
        long prev = Long.MAX_VALUE;
        for (Map.Entry<Pair, Integer> e : map.entrySet()) {
            Pair pair = e.getKey();
            int cn = e.getValue();
            if(pair.c != prev){
                cnt = 0;
                prev = pair.c;
            } else {
                ans += cn*cnt;
            }
            cnt += cn;
        }
        out.println(2*ans);
    }
}
