package codeforces.ecr56;

import chelper.io.FastScanner;
import common.FenwickSmall;
import common.Treap;
import common.Treap.Node;

import java.io.PrintWriter;

public class E2 {
    Node[] t;
    private int get(int r, int br) {
        int ans = 0;
        while (r >= 0) {
            ans += Treap.countLower(t[r], br);
            r = (r & (r + 1)) - 1;
        }
        return ans;
    }

    private void add(int pos, int idx) {
        while (pos < t.length) {
            t[pos] = Treap.insert(t[pos], new Node(idx));
            pos |= pos + 1;
        }
    }

    private void remove(int pos, int idx){
        while (pos < t.length) {
            t[pos] = Treap.erase(t[pos], idx);
            pos |= pos + 1;
        }
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        int[] a = in.na(n);
        int[] b = in.na(n);
        int[] bi = new int[n+1];
        for (int i = 0; i < n; i++) {
            bi[b[i]] = i;
        }
        int[] abi = new int[n];
        int[] ai = new int[n+1];
        for (int i = 0; i < n; i++) {
            abi[i] = bi[a[i]];
            ai[a[i]] = i;
        }
        int len =(int) Math.sqrt(n) + 1;
        t = new Node[len+3];
        for (int i = 0; i < n; i++) {
            int ind = i/len;
            add(ind, abi[i]);
        }
        for (int q = 0; q < m; q++) {
            int op = in.ni();
            if(op == 1){
                int al = in.ni()-1, ar = in.ni()-1, bl = in.ni()-1, br = in.ni()-1;
                int cl = al/len, cr = ar/len;
                int ans = 0;
                if(cl == cr){
                    for (int i = al; i <= ar; i++) {
                        if(bl <= abi[i] && abi[i] <= br)
                            ans++;
                    }
                } else {
                    ans += get(cr-1, br+1) - get(cr-1, bl) - get(cl, br+1) + get(cl, bl);

                    for (int i = al; i < (cl+1)*len ; i++) {
                        if(bl <= abi[i] && abi[i] <= br)
                            ans++;
                    }
                    for (int i = cr*len; i <=ar; i++) {
                        if(bl <= abi[i] && abi[i] <= br)
                            ans++;
                    }
                }


                out.println(ans);
            } else {
                int x = in.ni()-1, y = in.ni()-1;
                int xv = b[x]; int yv = b[y];
                int axi = ai[xv];int ayi = ai[yv];
                int cx = axi/len;
                int cy = ayi/len;
                if(cx != cy){
                    remove(cx, x);
                    remove(cy, y);
                    add(cx, y);
                    add(cy, x);
                }
                abi[axi] = y;
                abi[ayi] = x;
                b[y] = xv;b[x] = yv;
            }
        }
    }
}
