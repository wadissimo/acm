package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class R474F {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        int[] from = new int[m];
        int[] to = new int[m];
        int[] w = new int[m];
        for (int i = 0; i < m; i++) {
            from[i] = in.ni()-1;
            to[i] = in.ni()-1;
            w[i] = in.ni();
        }
        TreeMap<Integer, Integer>[] dp = new TreeMap[n];
        for (int i = 0; i < n; i++) {
            dp[i] = new TreeMap<>();
        }
        int ans = 0;
        for (int i = 0; i < m; i++) {
            Map.Entry<Integer, Integer> lowerEntry = dp[from[i]].lowerEntry(w[i]);
            int best = 1;
            if(lowerEntry != null){
                best = lowerEntry.getValue()+1;
            }
            ans = Math.max(ans, best);
            Map.Entry<Integer, Integer> insertFloor = dp[to[i]].floorEntry(w[i]);
            if(insertFloor == null || insertFloor.getValue() < best){
                dp[to[i]].put(w[i], best);
                Map.Entry<Integer, Integer> higherEntry = dp[to[i]].higherEntry(w[i]);
                while(higherEntry != null && higherEntry.getValue() <= best){
                    dp[to[i]].remove(higherEntry.getKey());
                    higherEntry = dp[to[i]].higherEntry(w[i]);
                }
            }
        }
        out.println(ans);
    }
}
