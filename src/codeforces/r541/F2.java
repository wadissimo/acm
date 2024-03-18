package codeforces.r541;

import chelper.io.FastScanner;
import common.DSUSize;

import java.io.PrintWriter;
import java.util.LinkedList;

public class F2 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int m = in.ni();
        DSUSize dsu = new DSUSize(m);
        LinkedList<Integer>[] lst = new LinkedList[m];
        for (int i = 0; i < m; i++) {
            lst[i] = new LinkedList<>();
            lst[i].add(i);
        }
        for (int i = 0; i < m-1; i++) {
            int a = in.ni()-1; int b = in.ni()-1;
            LinkedList<Integer> from, to;
            int ra = dsu.find(a);
            int rb = dsu.find(b);
            if(dsu.size[ra] < dsu.size[rb]){
                from = lst[ra]; to = lst[rb];
            } else {
                from = lst[rb]; to = lst[ra];
            }
            dsu.union(a, b);
            for (Integer num : from) {
                to.add(num);
            }
        }
        int root = dsu.find(0);
        for (Integer num : lst[root]) {
            out.print((num+1) + " ");
        }
        out.println();


    }
}
