package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class ecr29E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        TreeMap<Integer, Integer> coords = new TreeMap<>();
        Segment[] segs = new Segment[n];
        for (int i = 0; i < n; i++) {
            segs[i] = new Segment(i, in.ni(), in.ni());
            coords.put(segs[i].from, -1);
            coords.put(segs[i].to+1, -1);
        }
        int idx = 0;
        for (Map.Entry<Integer, Integer> entry : coords.entrySet()) {
            entry.setValue(idx++);
        }
        int size = idx;
        int[] cnts = new int[size + 3];
        for (int i = 0; i < n; i++) {
            segs[i].from = coords.get(segs[i].from);
            segs[i].to = coords.get(segs[i].to+1);
//            System.out.printf("Segment %d %d%n", segs[i].from, segs[i].to);
            cnts[segs[i].from]++;
            cnts[segs[i].to]--;
        }
//        System.out.println("Arrays.toString(cnts) = " + Arrays.toString(cnts));
        int cur = 0;
        int[] pref = new int[size + 3];
        for (int i = 0; i <= size + 1; i++) {
            cur += cnts[i];
            pref[i + 1] = pref[i];
            if (cur == 1) {
                pref[i + 1]++;
            }
        }
//        System.out.println("Arrays.toString(pref) = " + Arrays.toString(pref));
        for (int i = 0; i < n; i++) {
            if (pref[segs[i].from] == pref[segs[i].to]) {
                out.println(segs[i].id + 1);
                return;
            }
        }
        out.println(-1);
    }

    class Segment {
        int id;
        int from;
        int to;

        public Segment(int id, int from, int to) {
            this.id = id;
            this.from = from;
            this.to = to;
        }

    }
}
