package codeforces.r559;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.TreeMap;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni();
        int[] a = in.na(N);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Integer[] ord = new Integer[N];
        for (int i = 0; i < N; i++) {
            ord[i] = i;
        }
        Arrays.sort(ord, (x,y)->Integer.compare(a[x], a[y]));
        for (int i = 0; i < N; i++) {
            map.put(i, a[i]);
        }
        int ans = 1_000_000_000;
        for (int i = 0; i < N; i++) {
            int pos = ord[i];
            int max = Math.max(pos-map.firstKey(), map.lastKey()-pos);
            if(max == 0)
                continue;
            int k = a[pos]/max;
            ans = Math.min(ans, k);
            map.remove(pos);
        }
        out.println(ans);
    }
}
