package codeforces.ecr56;

import chelper.io.FastScanner;
import java.io.PrintWriter;

import static java.lang.Math.min;

public class G {


    int k;
    long[][] val;

    void buildMin (long[] t, long [] a, int v, int tl, int tr) {
        if (tl == tr) {
            t[v] = a[tl];
        } else {
            int tm = (tl + tr) / 2;
            buildMin (t, a, v*2, tl, tm);
            buildMin (t, a, v*2+1, tm+1, tr);
            t[v] = Math.min(t[v*2], t[v*2+1]);
        }
    }

    void buildMax (long[] t, long [] a, int v, int tl, int tr) {
        if (tl == tr) {
            t[v] = a[tl];
        } else {
            int tm = (tl + tr) / 2;
            buildMax (t, a, v*2, tl, tm);
            buildMax (t, a, v*2+1, tm+1, tr);
            t[v] = Math.max(t[v*2], t[v*2+1]);
        }
    }



    long max (long[] t, int v, int tl, int tr, int l, int r) {
        if(l>r)
            return Integer.MIN_VALUE;
        if (l == tl && r == tr)
            return t[v];
        int tm = (tl + tr) / 2;
        return Math.max(max (t, v*2, tl, tm, l, Math.min(r,tm)), max (t, v*2+1, tm+1, tr, Math.max(l,tm+1), r));
    }

    long min (long[] t, int v, int tl, int tr, int l, int r) {
        if(l>r)
            return Integer.MAX_VALUE;
        if (l == tl && r == tr)
            return t[v];
        int tm = (tl + tr) / 2;
        return Math.min(min (t, v*2, tl, tm, l, Math.min(r,tm)), min (t, v*2+1, tm+1, tr, Math.max(l,tm+1), r));
    }


    void updateMax (long[] t, int v, int tl, int tr, int pos, long new_val) {
        if (tl == tr) {
            t[v] = new_val;
        }else {
            int tm = (tl + tr) / 2;
            if (pos <= tm)
                updateMax (t, v*2, tl, tm, pos, new_val);
            else
                updateMax (t, v*2+1, tm+1, tr, pos, new_val);
            t[v] = Math.max(t[v*2], t[v*2+1]);
        }
    }

    void updateMin (long[] t, int v, int tl, int tr, int pos, long new_val) {
        if (tl == tr) {
            t[v] = new_val;
        }else {
            int tm = (tl + tr) / 2;
            if (pos <= tm)
                updateMin (t, v*2, tl, tm, pos, new_val);
            else
                updateMin (t, v*2+1, tm+1, tr, pos, new_val);
            t[v] = Math.min(t[v*2], t[v*2+1]);
        }
    }



    private void setMax(long[] tree, int i, long value) {
        i += tree.length / 2;
        tree[i] = value;
        for (; i > 1; i >>= 1)
            tree[i >> 1] = Math.max(tree[i], tree[i ^ 1]);
    }

    private long getMax(long[] tree, int l, int r) {
        long res = Long.MIN_VALUE;
        for (l += tree.length / 2, r += tree.length / 2; l <= r; l = (l + 1) >> 1, r = (r - 1) >> 1) {
            res = Math.max(res, tree[l]);
            res = Math.max(res, tree[r]);
        }
        return res;
    }

    private void setMin(long[] tree, int i, long value) {
        i += tree.length / 2;
        tree[i] = value;
        for (; i > 1; i >>= 1)
            tree[i >> 1] = Math.min(tree[i], tree[i ^ 1]);
    }

    private long getMin(long[] tree, int l, int r) {
        long res = Long.MAX_VALUE;
        for (l += tree.length / 2, r += tree.length / 2; l <= r; l = (l + 1) >> 1, r = (r - 1) >> 1) {
            res = Math.min(res, tree[l]);
            res = Math.min(res, tree[r]);
        }
        return res;
    }




    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        k = in.ni();
        int[][] p = new int[n][];
        for (int i = 0; i < n; i++) {
            p[i] = in.na(k);
        }

        val = new long[1<<(k-1)][n];
        for (int mask = 0; mask < 1<<(k-1); mask++) {
            for (int j = 0; j < k; j++) {
                if((mask & (1<<j)) != 0){
                    for (int i = 0; i < n; i++) {
                        val[mask][i] += p[i][j];
                    }
                } else {
                    for (int i = 0; i < n; i++) {
                        val[mask][i] -= p[i][j];
                    }
                }
            }
        }
        int q = in.ni();
        long[][] maxTree = new long[1<<(k-1)][n*2];
        long[][] minTree = new long[1<<(k-1)][n*2];
        for (int i = 0; i < 1 << k - 1; i++) {
            for (int j = 0; j < n; j++) {
                setMax(maxTree[i], j, val[i][j]);
                setMin(minTree[i], j, val[i][j]);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < q; i++) {
            int op = in.ni();
            if(op == 1){
                int num = in.ni()-1;
                int[] np = in.na(k);
                for (int mask = 0; mask < 1<<(k-1); mask++) {
                    val[mask][num] = 0;
                    for (int j = 0; j < k; j++) {
                        if((mask & (1<<j)) != 0){
                            val[mask][num] += np[j];
                        } else {
                            val[mask][num] -= np[j];
                        }
                    }
                }
                for (int j = 0; j < 1 << k - 1; j++) {
                    setMax(maxTree[j], num, val[j][num]);
                    setMin(minTree[j], num, val[j][num]);
                }

            } else {
                long ans = 0;
                int l = in.ni()-1, r = in.ni()-1;
                for (int j = 0; j < 1 << (k-1); j++) {
                    long max = getMax(maxTree[j], l, r);
                    long min = getMin(minTree[j], l, r);
                    ans = Math.max(ans, max-min);
                    ans = Math.max(ans, -min+max);
                }
                sb.append(ans).append('\n');
            }
        }
        out.print(sb.toString());

    }
}
