package codeforces.r539;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.TreeMap;
import java.util.TreeSet;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int[] pref = new int[n+1];
        for (int i = 0; i < n; i++) {
            pref[i+1] = pref[i]^a[i];
        }
        TreeMap<Integer, Integer> odd = new TreeMap<>();
        TreeMap<Integer, Integer> even = new TreeMap<>();
        even.put(0, 1);
        long ans = 0;
        for (int i = 1; i <= n; i++) {
            if(i%2 == 0){
                if(even.containsKey(pref[i]))
                    ans += even.get(pref[i]);
                even.put(pref[i], even.getOrDefault(pref[i], 0) + 1);
            } else {
                if(odd.containsKey(pref[i]))
                    ans += odd.get(pref[i]);
                odd.put(pref[i], odd.getOrDefault(pref[i], 0) + 1);
            }
        }
        out.println(ans);
    }
}
