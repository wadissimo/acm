package codeforces.gb2018;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.TreeSet;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        ArrayList<Integer> divs = new ArrayList<>();
        int div = 1;
        for (; div*div < n; div++) {
            if(n%div == 0){
                divs.add(div);
                divs.add(n/div);
            }
        }
        if(div*div == n)
            divs.add(div);
        TreeSet<Long> set = new TreeSet<>();
        for (int d : divs) {
            long sum = (n+2-d);
            set.add(sum*n/d/2);
        }
        for (long s : set) {
            out.printf("%d ", s);
        }
        out.println();
    }
}
