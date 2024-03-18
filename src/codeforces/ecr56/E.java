package codeforces.ecr56;

import chelper.io.FastScanner;
import common.Treap;
import common.Treap.Node;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.TreeSet;

public class E {

    public static void build (Node[] t, int[] abi) {
        build(t, abi, 1, 0, abi.length-1);
    }

    public static void build (Node[] t, int[] abi, int v, int tl, int tr) {
        if (tl == tr) {
            t[v] = new Node(abi[tl]);
        } else {
            int tm = (tl + tr) / 2;
            build (t, abi, v*2, tl, tm);
            build (t, abi, v*2+1, tm+1, tr);
            t[v] = Treap.copy(t[v*2]);
            //todo:
            Node n = Treap.min(t[v*2+1]);
            while(n != null){
                t[v] = Treap.insert(t[v], new Node(n.key));
                n = Treap.next(n);
            }
        }
    }

    public static long getAns (Node[] t, int v, int tl, int tr, int al, int ar, int bl, int br) {
        if (al == tl && ar == tr){
            return Treap.countLower(t[v], br+1) - Treap.countLower(t[v], bl);
        }
        int tm = (tl + tr) / 2;
        if(ar<=tm){
            return getAns (t, v*2, tl, tm, al, ar, bl, br);
        } else if (al > tm){
            return getAns (t, v*2+1, tm+1, tr, al, ar, bl, br);
        } else {
            return getAns(t, v*2, tl, tm, al, tm, bl, br) + getAns(t, v*2+1, tm+1, tr, tm+1, ar, bl, br);
        }
    }

    public static void update (Node[] t, int v, int tl, int tr, int pos, int source, int target) {
        if (tl == tr) {
            if(t[v].key == source)
                t[v] = new Node(target);
            else
                throw new RuntimeException("key not found");
        } else {

            Node ynode = Treap.search(t[v], target);
            if(ynode == null){
                t[v] = Treap.erase(t[v], source);
                t[v] = Treap.insert(t[v], new Node(target));
            }

            int tm = (tl + tr) / 2;
            if (pos <= tm)
                update (t, v*2, tl, tm, pos, source, target);
            else
                update (t, v*2+1, tm+1, tr, pos, source, target);
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
        Node[] t = new Node[4*n];
        build(t, abi);
        for (int q = 0; q < m; q++) {
            int op = in.ni();
            if (op == 1) {
                int al = in.ni()-1, ar = in.ni()-1, bl = in.ni()-1, br = in.ni()-1;
                long ans = getAns(t, 1, 0, n-1, al, ar, bl, br);
                out.println(ans);
            } else {
                int x = in.ni()-1, y = in.ni()-1;
                int xv = b[x]; int yv = b[y];
                int axi = ai[xv];int ayi = ai[yv];
                update(t, 1, 0, n-1, axi, x, y);
                update(t, 1, 0, n-1, ayi, y, x);
                b[y] = xv;b[x] = yv;
            }
        }

    }
}

