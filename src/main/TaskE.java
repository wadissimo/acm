package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.TreeSet;

public class TaskE {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni(), X = in.ni();
        int[] a = in.na(N);
        int INF = 2_000_000;
        int[] higherMin = new int[X+1];
        int[] higherMax = new int[X+1];
        Arrays.fill(higherMin, INF);
        TreeSet<Integer> set = new TreeSet<>();
        for (int i = 0; i < N; i++) {
            if(!set.isEmpty()){
                Integer last = set.last();
                if(last > a[i]) {
                    higherMax[a[i]] = Math.max(higherMax[a[i]], last);
                    higherMin[a[i]] = Math.min(higherMin[a[i]], set.higher(a[i]));
                }
            }
            set.add(a[i]);
        }
        int longestPrefix = 0;
        int min = INF;
        for (int i = 1; i <=X; i++) {
            min = Math.min(min, higherMin[i]);
            if(min < i){
                longestPrefix = i-1;
                break;
            }
        }
        int[] lowerMin = new int[X+1];
        int[] lowerMax = new int[X+1];

        Arrays.fill(lowerMin, INF);
        set.clear();
        for(int i = N-1; i >= 0;--i){
            if(!set.isEmpty()) {
                Integer first = set.first();
                if (first < a[i]) {
                    lowerMin[a[i]] = Math.min(lowerMin[a[i]], first);
                    lowerMax[a[i]] = Math.max(lowerMax[a[i]], set.lower(a[i]));
                }
            }
            set.add(a[i]);
        }
        long ans = longestPrefix+1;
        int max = 0;
        for (int i = X ; i > 0 ; i--) {
            max = Math.max(max, lowerMax[i]);
            if(max > i){
                break;
            }
            ans += lowerMin[i];//todo: compress
        }
    }
}
