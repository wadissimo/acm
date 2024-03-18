package atcoder.agc029;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.*;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            LinkedList<Integer> update = map.computeIfAbsent(a[i], k -> new LinkedList<>());
            update.add(i);
        }
        int ans = 0;
        for (int j = 30; j > 0; j--) {
            int pow = 1<<j;
            //System.out.println("pow = " + pow);
            for (int i = 0; i < n; i++) {
                LinkedList<Integer> cur = map.get(a[i]);
                if(cur.size() == 0)
                    continue;
                LinkedList<Integer> pairs = map.get(pow - a[i]);
                if(pairs != null && pairs.size() > 0){
                    if(pow-a[i] == a[i] && pairs.size() == 1)
                        continue;
                    pairs.poll();
                    cur.poll();
                    ans++;
                }

            }
        }
        out.println(ans);
    }
}
