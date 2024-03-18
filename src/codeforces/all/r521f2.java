package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class r521f2 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();int k = in.ni();int x = in.ni();
        int[] a = in.na(n);
        long[][] layer = new long[x][n];
        for (int i = 0; i < k; i++) {
            layer[0][i] = a[i];
        }
        //System.out.println(Arrays.toString(layer[0]));
        for (int step = 1; step < x; step++) {
            Deque<Long> maxQueue = new LinkedList<>();
            maxQueue.push(layer[step-1][step-1]);
            for (int i = step; i < n; i++) {
                long max = maxQueue.peekLast();
                if(max == 0)
                    break;
                layer[step][i] = max+a[i];
                while(!maxQueue.isEmpty() && maxQueue.peekFirst() < layer[step-1][i])
                    maxQueue.pollFirst();
                if(i-k >= 0 && !maxQueue.isEmpty() && maxQueue.peekLast() == layer[step-1][i-k])
                    maxQueue.pollLast();
                maxQueue.push(layer[step-1][i]);
            }
            //System.out.println(Arrays.toString(layer[step]));
        }
        long max = 0;
        for (int i = 0; i < k; i++) {
            max = Math.max(layer[x-1][n-i-1], max);
        }
        if(max == 0)
            out.println(-1);
        else
            out.println(max);

    }
}
