package codeforces.r541;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        Arrays.sort(a);
        LinkedList<Integer> l = new LinkedList<>();
        l.addFirst(a[0]);
        for (int i = 1; i < n; i++) {
            if(i%2 == 1)
                l.addFirst(a[i]);
            else
                l.addLast(a[i]);
        }
        for (Integer id : l) {
            out.print(id + " ");
        }
    }
}
