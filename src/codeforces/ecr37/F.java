package codeforces.ecr37;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

public class F {
    class Node{
        long[] val;
        int replace;
        int level;

        public Node(long[] val) {
            this.val = val;
        }
    }
    Node[] tree;
    int[] a;
    int[][] b;

    private void build(int v, int tl, int tr){
        if(tl == tr){
            long[] c = new long[10];
            for (int i = 0; i < 10; i++) {
                c[i] = b[tl][i];
            }
            tree[v] = new Node(c);
            return;
        }
        int tm = (tl+tr)/2;
        build(v*2, tl, tm);
        build(v*2+1, tm+1, tr);
        long[] c = new long[10];
        for (int i = 0; i < 10; i++) {
            c[i] = tree[v*2].val[i] + tree[v*2+1].val[i];
        }
        tree[v] = new Node(c);
    }
    private void push(int v){
        if(tree[v].replace == 0)
            return;
        if(v*2 < tree.length && tree[v*2] != null) {
            tree[v * 2].replace += tree[v].replace;
            tree[v * 2 + 1].replace += tree[v].replace;
        }
        if(tree[v].level < 9) {
            tree[v].level += tree[v].replace;
            if(tree[v].level > 9)
                tree[v].level = 9;
        }
        tree[v].replace = 0;
    }

    private void replace (int v, int tl, int tr, int l, int r, int replace){
        if(tl == l && tr == r){
            tree[v].replace+=replace;
            push(v);
            return;
        }
        push(v);
        int tm = (tl+tr)/2;
        if(r <= tm){
            replace(v*2, tl, tm, l, r, replace);
        } else if(l>tm){
            replace(v*2+1, tm+1, tr, l, r, replace);
        } else {
            replace(v*2, tl, tm, l, tm, replace);
            replace(v*2+1, tm+1, tr, tm+1, r, replace);
        }
        for (int i = 0; tree[v].level+i < 10; i++) {
            tree[v].val[tree[v].level+i] = tree[v*2].val[Math.min(tree[v*2].level+tree[v*2].replace+i, 9)] + tree[v*2+1].val[Math.min(tree[v*2+1].level+tree[v*2+1].replace+i, 9)];
        }
    }

    long sum(int v, int tl, int tr, int l, int r){
        if(tl == l && tr == r){
            push(v);
            return tree[v].val[tree[v].level];
        }
        push(v);
        int tm = (tl +tr)/2;
        long a = 0, b = 0;
        if(r<=tm){
            a = sum(v*2, tl, tm, l, r);
        }else if(l>tm){
            b = sum(v*2+1, tm+1, tr, l, r);
        } else {
            a = sum (v * 2, tl, tm, l, tm);
            b = sum(v * 2 + 1, tm + 1, tr, tm + 1, r);
        }
        for (int i = 0; tree[v].level+i < 10; i++) {
            tree[v].val[tree[v].level+i] = tree[v*2].val[Math.min(tree[v*2].level+tree[v*2].replace+i, 9)] + tree[v*2+1].val[Math.min(tree[v*2+1].level+tree[v*2+1].replace+i, 9)];
        }
        return a+b;
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int MAX = 1_000_000;
        ArrayList<Integer> pr = new ArrayList<>();
        int[] lp = new int[MAX +7];
        IntegerUtils.sieve(MAX, pr, lp);
        int[] d = new int[MAX + 7];
        d[1] = 1;
        for (int num = 2; num <= MAX; num++) {
            int cur = num;
            int power = 1;
            while(cur%lp[num] == 0){
                cur /= lp[num];
                power++;
            }
            d[num] = power*d[cur];
        }
        int n = in.ni(), m = in.ni();
        a = in.na(n);

        b = new int[n][10];
        for (int i = 0; i < n; i++) {
            b[i][0] = a[i];
        }
        for (int i = 0; i < n; i++) {
            for (int k = 1; k < 10; k++) {
                b[i][k] = d[b[i][k-1]];
            }
        }
        /*for (int k = 0; k < 10; k++) {
            for (int i = 0; i < n; i++) {
                System.out.print(b[i][k] +  " ");
            }
            System.out.println();
        }*/

        tree = new Node[4*n];
        build(1, 0, n-1);
        for (int i = 0; i < m; i++) {
            int op = in.ni(), l = in.ni()-1, r = in.ni()-1;
            if(op == 1){
                /*for (int j = l; j <=r ; j++) {
                    a[j] = d[a[j]];
                }*/
                replace(1, 0, n-1, l, r, 1);
            } else {
                /*long sum = 0;
                for (int j = l; j <=r; j++) {
                    sum+=a[j];
                }
                System.out.println("sum = " + sum);
                */
                out.println(sum(1, 0, n-1, l, r));
            }
        }



    }
}
