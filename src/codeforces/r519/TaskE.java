package codeforces.r519;

import chelper.io.FastScanner;
import common.Fenwick;
import common.GraphUtil;

import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class TaskE {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(); int m = in.ni();
        long[] x = new long[n];
        long[] y = new long[n];
        for (int i = 0; i < n; i++) {
            x[i] = in.ni(); y[i] = in.ni();
        }

        int[][] g = in.readGraph(n,m);

        //long SHIFT = 2000000001L;
        long dif[] = new long[n];
        TreeMap<Long, Integer> compressMap = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            dif[i] = x[i] - y[i];
            compressMap.put(dif[i], 1);
        }
        int index = 0;
        int compressSize = compressMap.size();
        long[] restore = new long[compressSize];

        for (Map.Entry<Long, Integer> entry : compressMap.entrySet()) {
            entry.setValue(index);
            restore[index] = entry.getKey();
            index++;
        }
        Fenwick treeY = new Fenwick(compressSize+7);
        Fenwick treeX = new Fenwick(compressSize+7);
        Fenwick treeN = new Fenwick(compressSize+7);
        for (int i = 0; i < n; i++) {
            Integer idx = compressMap.get(dif[i]);
            treeX.add(idx, x[i]);
            treeY.add(idx, y[i]);
            treeN.add(idx, 1);
        }
        long[] ans = new long[n];
        for (int i = 0; i < n; i++) {
            Integer splitIdx = compressMap.get(x[i] - y[i]);
            ans[i] = treeY.get(compressSize+1)-treeY.get(splitIdx) + (treeN.get(compressSize+1) - treeN.get(splitIdx))*x[i];//> split
            ans[i] += treeX.get(splitIdx)-x[i] + (treeN.get(splitIdx)-1)*y[i];
        }
        for (int v = 0; v < n; v++) {
            for (int u : g[v]) {
                long x1 = x[v];
                long y1 = y[v];
                long x2 = x[u];
                long y2 = y[u];
                long sum = Math.min(x1+y2, x2+y1);
                ans[v]-=sum;
            }
        }

        for (int i = 0; i < n; i++) {
            out.print(ans[i] + " ");
        }
        out.println();

    }
}

