package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class r462D2 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        ArrayList<Integer>[] a = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            a[i] = new ArrayList<>();
        }
        for (int i = 0; i < m; i++) {
            int from = in.ni()-1, to = in.ni()-1;
            if(to < from)
                to += n;
            a[from].add(to-from);
        }
        int maxSize = 0;
        for (int i = 0; i < n; i++) {
            Collections.sort(a[i]);
            maxSize = Math.max(maxSize, a[i].size());
        }
        for (int i = 0; i < n; i++) {
            long cur = (maxSize > 1? maxSize-2:0)*(long)n;
            int ind = i;
            long max = cur;
            for (int size = Math.max(1, maxSize-1); size <= maxSize; size++) {
                for (int j = 0; j < n; j++) {
                    if(a[ind].size() >= size){
                        max = Math.max(max, cur + a[ind].get(a[ind].size() - size));
                    }
                    cur++;
                    ind++;
                    if(ind == n)
                        ind = 0;
                }
            }
            out.print(max + " ");
        }
    }
}
