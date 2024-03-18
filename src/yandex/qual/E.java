package yandex.qual;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class E {
    private TreeSet<Integer> divs (int a) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 1; i <= Math.sqrt(a); i++) {
            if(a % i == 0) {
                set.add(i);
                set.add(a/i);
            }
        }
        set.add(a);
        return set;
    }
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int m = in.ni();
        long l = in.nl();
        long r = in.nl();
        if(n > m) {
            int t = n;
            n = m;
            m = t;
        } //n < m
        TreeSet<Integer> nDivs = divs(n);
        TreeSet<Integer> mDivs = divs(m);
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int i = 1;
        for (Integer div : mDivs) {
            map.put(div, i);
            i++;
        }
        long res = 0;
        for (Integer div : nDivs) {
            long topM = r / div;
            if(topM > m) topM = m;
            Map.Entry<Integer, Integer> entry = map.floorEntry((int)topM);
            if(entry != null) {
                int top = entry.getValue();
                long botM = l / div;
                if (botM > m) continue;
                if(botM*div < l) {
                    botM ++;
                }
                entry = map.ceilingEntry((int)botM);
                if(entry != null) {
                    int bot = entry.getValue();
                    res += top - bot + 1;
                }
            }

        }
        out.println(res);


    }
}
