package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class Activities {
    class Segment{
        int from , to;

        public Segment(int from, int to) {
            this.from = from;
            this.to = to;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        while(true){
            int N = in.ni();
            if(N == -1)
                break;
            Segment[] segs = new Segment[N];
            for (int i = 0; i < N; i++) {
                segs[i] = new Segment(in.ni(), in.ni());
            }
            Arrays.sort(segs, (x,y)->Integer.compare(x.to, y.to));
            TreeMap<Integer, Long> map = new TreeMap<>();
            map.put(0,1L);
            long mod = 100_000_000;
            for (int i = 0; i < N; i++) {
                Map.Entry<Integer, Long> beforeEntry= map.floorEntry(segs[i].from);
                Map.Entry<Integer, Long> curEntry= map.floorEntry(segs[i].to);
                long cur = curEntry != null? curEntry.getValue():0;
                long before = beforeEntry != null ? beforeEntry.getValue():0;
                map.put(segs[i].to, (cur+before)%mod);
            }
            String ans = Long.toString((map.lastEntry().getValue() +mod-1)%mod);
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 8 - ans.length(); i++) {
                sb.append('0');
            }
            sb.append(ans);
            out.println(sb);
        }
    }
}
