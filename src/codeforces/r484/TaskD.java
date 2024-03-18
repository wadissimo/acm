package codeforces.r484;

import chelper.io.FastScanner;
import common.ArrayUtils;
import common.DSU;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TaskD {
    private void removeSeg(HashMap<Integer, Integer> counter, Integer segment){
        Integer cnt = counter.get(segment);
        if(cnt == 1){
            counter.remove(segment);
        } else {
            counter.put(segment, cnt-1);
        }
    }

    private void union(DSU dsu, HashMap<Integer, Integer> segCount, HashMap<Integer, Integer> dsuSeg, int ai, int bi){
        int left = dsu.find(ai);
        int right = dsu.find(bi);
        int leftSize = dsuSeg.get(left);
        int rightSize = dsuSeg.get(right);
        removeSeg(segCount, leftSize);
        removeSeg(segCount, rightSize);
        int newSize = leftSize+rightSize;
        segCount.merge(newSize, 1, (x, y) -> x + y);
        dsu.union(ai, bi);
        dsuSeg.put(dsu.find(ai), newSize);
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[]a = in.na(n);
        if(n==1){
            out.println(a[0]+1);
            return;
        }
        //if(n==2)
        TreeMap<Integer,Integer> hs = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            hs.put(a[i], i);
        }
        DSU dsu = new DSU(n);
        HashMap<Integer, Integer> segCount = new HashMap<>();
        HashMap<Integer, Integer> dsuSeg = new HashMap<>();
        int ans = 0;
        int maxCount = 0;
        for (Map.Entry<Integer, Integer> entry : hs.entrySet()) {
            int h = entry.getKey();
            int i = entry.getValue();
            dsuSeg.put(dsu.find(i), 1);
            segCount.merge(1, 1, (x, y) -> x + y);
            if(i > 0 && a[i-1] < a[i]){
                union(dsu, segCount, dsuSeg, i-1, i);
            }
            if(i < n-1 && a[i+1] < a[i]){
                union(dsu, segCount, dsuSeg, i+1, i);
            }
            if(segCount.size() == 1){
                Integer size = segCount.values().iterator().next();
                if(size > maxCount){
                    maxCount = size;
                    ans = h+1;
                }
            }
        }
      //  System.out.println(maxCount);
        out.println(ans);

    }
}
