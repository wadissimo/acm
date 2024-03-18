package codeforces.r485;

import chelper.io.FastScanner;
import common.Fenwick;

import java.io.PrintWriter;
import java.util.Random;

public class TaskBCHeck {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int [] a = new int[n];
        int [] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i+1;
            b[i] = i+1;
        }
        Random rand = new Random();
        for (int i = 0; i < 3 * n; i++) {
            int x = rand.nextInt(n);
            int y = rand.nextInt(n-1);
            if(y>=x)
                y++;
            int t = a[x];
            a[x] = a[y];
            a[y] = t;
        }

        for (int i = 0; i < 7 * n+1; i++) {
            int x = rand.nextInt(n);
            int y = rand.nextInt(n-1);
            if(y>=x)
                y++;
            int t = b[x];
            b[x] = b[y];
            b[y] = t;
        }
        Fenwick tree = new Fenwick(n+7);
        long cnt = 0;
        for (int i = 0; i < n; i++) {
            cnt += tree.get(n)- tree.get(a[i]);
            tree.add(a[i], 1);
            System.out.print(a[i]+ " ");
        }
        System.out.println();
        System.out.println(cnt);
        cnt = 0;
        tree = new Fenwick(n+7);
        for (int i = 0; i < n; i++) {
            cnt += tree.get(n)- tree.get(b[i]);
            tree.add(b[i], 1);
            System.out.print(b[i]+ " ");
        }
        System.out.println();
        System.out.println(cnt);

    }
}
