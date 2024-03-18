package codeforces.all;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;

public class r458D {
    long[] tree;
    void build(int[] a, int v, int tl, int tr){
        if(tl == tr){
            tree[v] = a[tl];
        } else {
            int tm = (tl+tr)/2;
            build(a, v*2, tl, tm);
            build(a, v*2+1, tm+1, tr);
            tree[v] = IntegerUtils.gcd(tree[v*2], tree[v*2+1]);
        }
    }
    void update(int v, int tl, int tr, int pos, int val){
        if(tl == tr){
            tree[v] = val;
        } else {
            int tm = (tl+tr)/2;
            if(pos <= tm){
                update(v*2, tl, tm, pos, val);
            } else {
                update(v*2+1, tm+1, tr, pos, val);
            }
            tree[v] = IntegerUtils.gcd(tree[v*2], tree[v*2+1]);
        }
    }
    int query(int v, int tl, int tr, int l, int r, int x){
        int tm = (tl+tr)/2;
        if(tl == l && tr == r){
            if(tree[v]%x == 0)
                return 0;
            if(tl == tr)
                return tree[v] % x == 0 ? 0:1;
            if(tree[v*2]%x == 0)
                return query(v*2+1, tm+1, tr, tm+1, tr, x);
            else if(tree[v*2+1]%x == 0)
                return query(v*2, tl, tm, tl, tm, x);
            else
                return -1;
        }
        if(r<=tm)
            return query(v*2, tl, tm, l, tm, x);
        else if(l > tm)
            return query(v*2+1, tm+1, tr, tm+1, r, x);
        int lres = query(v*2, tl, tm, l, tm, x);
        int rres = query(v*2+1, tm+1, tr, tm+1, r, x);
        if(lres == -1 || rres == -1 || lres == 1 && rres == 1)
            return -1;
        if(lres == 0 && rres == 0)
            return 0;
        else
            return 1;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        tree = new long[n*4];
        build(a, 1, 0, n-1);
        int q = in.ni();
        for (int i = 0; i < q; i++) {
            int op = in.ni();
            if(op == 1){
                int l = in.ni()-1, r = in.ni()-1, x = in.ni();
                int res = query(1, 0, n-1, l, r, x);
                if(res == -1)
                    out.println("NO");
                else
                    out.println("YES");
            } else {
                int pos = in.ni()-1, y = in.ni();
                update(1, 0, n-1, pos, y);
            }
        }

    }
}
