package codeforces.ecr56;

import chelper.io.FastScanner;
import common.Fenwick;
import common.FenwickSmall;
import common.Treap;
import common.Treap.Node;

import java.io.PrintWriter;

public class E1 {
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
        FenwickSmall[] decom = new FenwickSmall[len];
        for (int i = 0; i < len; i++) {
            decom[i] = new FenwickSmall(n+7);
        }
        for (int i = 0; i < n; i++) {
            int ind = i/len;
            decom[ind].add(abi[i], (short)1);
        }
        for (int q = 0; q < m; q++) {
            int op = in.ni();
            if(op == 1){
                int ans = 0;
                int al = in.ni()-1, ar = in.ni()-1, bl = in.ni()-1, br = in.ni()-1;
                int cl = al/len, cr = ar/len;
                if(cl == cr){
                    for (int i = al; i <= ar; i++) {
                        if(bl <= abi[i] && abi[i] <= br)
                            ans++;
                    }
                } else {
                    for (int i = cl+1; i < cr; i++) {
                        ans += decom[i].get(br) - decom[i].get(bl-1);
                    }
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
                    decom[cx].add(x, (short)-1);
                    decom[cx].add(y, (short)1);
                    decom[cy].add(y, (short)-1);
                    decom[cy].add(x, (short)1);
                }
                abi[axi] = y;
                abi[ayi] = x;
                b[y] = xv;b[x] = yv;
            }
        }


    }
}
