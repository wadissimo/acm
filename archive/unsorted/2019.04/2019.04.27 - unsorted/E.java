package codeforces.r555;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        TreeMap<Integer, Integer> set = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            int b = in.ni();
            set.put(b, set.getOrDefault(b, 0)+1);
        }
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> ceiling = set.ceilingEntry(n - a[i]);
            if(ceiling == null){
                Map.Entry<Integer, Integer> min = set.firstEntry();
                c[i] = (a[i] + min.getKey())%n;
                if(min.getValue() == 1){
                    set.remove(min.getKey());
                } else {
                    set.put(min.getKey(), min.getValue()-1);
                }
            } else {
                c[i] = (a[i] + ceiling.getKey())%n;
                if(ceiling.getValue() == 1){
                    set.remove(ceiling.getKey());
                } else {
                    set.put(ceiling.getKey(), ceiling.getValue()-1);
                }
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(c[i] + " ");
        }
    }
}
