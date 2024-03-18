package codeforces.r450;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int[] ans = new int[n+1];
        for (int i = 0; i < n; i++) {
            Map.Entry<Integer, Integer> higherEntry = map.higherEntry(a[i]);
            if(higherEntry != null){
                if(map.higherKey(higherEntry.getKey()) == null){
                    ans[higherEntry.getKey()] ++;
                }
            } else {
                ans[a[i]]--;
            }
            map.put(a[i], i);
        }
        int max = -1;
        for (int i = 1; i <= n; i++) {
            if(ans[i] > max){
                max = ans[i];
            }
        }

        for (int i = 1; i <= n; i++) {
            if(ans[i] == max) {
                out.println(i);
                return;
            }
        }



    }
}
