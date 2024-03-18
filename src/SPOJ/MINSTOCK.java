package SPOJ;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.TreeMap;

public class MINSTOCK {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        TreeMap<Integer, HashSet<String>> map = new TreeMap<>();
        HashMap<String, Integer> prices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int o = in.ni();
            if(o == 1){
                String s = in.ns();
                int p = in.ni();
                prices.put(s, p);
                HashSet<String> set = map.computeIfAbsent(p, k -> new HashSet<>());
                set.add(s);
            } else if(o==2){
                String s = in.ns();
                int new_price = in.ni();
                int price = prices.get(s);
                HashSet<String> set = map.get(price);
                if (set.size() == 1){
                    map.remove(price);
                }else {
                    set.remove(s);
                }
                set = map.computeIfAbsent(new_price, k -> new HashSet<>());
                set.add(s);
                prices.put(s, new_price);
            } else {
                in.ns();
                Map.Entry<Integer, HashSet<String>> best = map.pollFirstEntry();
                out.print(best.getValue().iterator().next());out.print(' ');out.println(i+1);
            }
        }
    }
}
