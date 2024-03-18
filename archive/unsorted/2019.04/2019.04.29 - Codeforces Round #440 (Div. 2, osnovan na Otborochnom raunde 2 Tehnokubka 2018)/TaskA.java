package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.HashSet;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        int[] a = in.na(n);
        HashSet<Integer> as = new HashSet<>();
        int[] b = in.na(m);
        HashSet<Integer> bs = new HashSet<>();
        int mina = 10;
        int minb = 10;
        for (int i = 0; i < n; i++) {
            as.add(a[i]);
            mina = Math.min(mina, a[i]);
        }
        for (int i = 0; i < m; i++) {
            bs.add(b[i]);
            minb = Math.min(minb, b[i]);
        }
        for (int i = 1; i <=9; i++) {
            if(as.contains(i) && bs.contains(i)){
                out.println(i);
                return;
            }
        }
        if(mina < minb){
            out.println(mina+ "" + minb );
        } else {
            out.println(minb+ "" + mina );
        }


    }
}
