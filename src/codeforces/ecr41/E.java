package codeforces.ecr41;

import chelper.io.FastScanner;
import common.Fenwick;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.TreeSet;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        LinkedList<Integer>[] todo = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            todo[i] = new LinkedList<>();
        }
        Fenwick invalids = new Fenwick(n+7);
        long ans = 0;
        for (int i = 0; i < n; i++) {
            for (int invalid : todo[i]) {
                invalids.add(invalid, 1);
            }
            int end = Math.min(a[i], i);
            ans += end - invalids.get(end);
            if(a[i] < n){
                if(a[i] <= i)
                    invalids.add(i+1, 1);
                else
                    todo[a[i]].add(i+1);
            }
        }
        out.println(ans);
    }
}
