package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class TaskB2 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] u = in.na(n);
        int MAX = 100_003;
        int[] cnt = new int[MAX];
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if(cnt[u[i]] > 0){
                Integer prev = map.get(cnt[u[i]]);
                if(prev == 1){
                    map.remove(cnt[u[i]]);
                } else {
                    map.put(cnt[u[i]], prev-1);
                }
            }
            cnt[u[i]]++;
            map.put(cnt[u[i]], map.getOrDefault(cnt[u[i]], 0)+1);
            if(map.size() == 1 && (map.firstKey() == 1 || map.firstEntry().getValue() == 1)){
                ans = i;
            } else if (map.size() == 2){
                Map.Entry<Integer, Integer> first = map.firstEntry();
                Map.Entry<Integer, Integer> last = map.lastEntry();
                if(first.getKey() == 1 && first.getValue() == 1){
                    ans = i;
                } else if(first.getKey()+1 == last.getKey() && last.getValue() == 1){
                    ans = i;
                }
            }
        }
        out.println(ans+1);
    }
}
