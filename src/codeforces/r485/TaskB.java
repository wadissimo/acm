package codeforces.r485;

import chelper.io.FastScanner;
import common.Fenwick;

import java.io.PrintWriter;
import java.util.Random;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int [] a = in.na(n);

        Fenwick tree = new Fenwick(n+7);
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += tree.get(n)- tree.get(a[i]);
            tree.add(a[i], 1);
        }
        out.println(cnt % 2 == n%2 ? "Petr":"Um_nik");
    }
}
