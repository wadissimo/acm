package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.*;

public class R476C {
    int MAX = 1_000_000_007;
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int w = in.ni(), l = in.ni();
        int[] a = new int[w+1];
        for (int i = 1; i < w; i++) {
            a[i] = in.ni();
        }
        int[] b = new int[w+1];
        a[0] = a[w] = b[0] = MAX;

        TreeSet<Integer> curSet = new TreeSet<>();
        curSet.add(0);
        TreeSet<Integer> nxtSet = new TreeSet<>();
        while(curSet.size() > 0){
            int ind = curSet.last();
            int cur = ind + l;
            if(cur > w)
                cur = w;
            if(curSet.first() == w)
                break;
            Iterator<Integer> it = curSet.descendingIterator();
            while(it.hasNext()) {
                ind = it.next();
                cur = Math.min(cur, ind + l);
                while(cur > ind){
                    if(a[cur] == 0)
                        cur--;
                    else if(a[cur] >= b[ind]){
                        nxtSet.add(cur);
                        a[cur] -= b[ind];
                        b[cur] += b[ind];
                        b[ind] = 0;
                        break;
                    } else {
                        nxtSet.add(cur);
                        b[cur] += a[cur];
                        b[ind] -= a[cur];
                        a[cur] = 0;
                        cur--;
                    }
                }
            }
            TreeSet<Integer> tmp = curSet; curSet = nxtSet; nxtSet = tmp;
            nxtSet.clear();
        }
        out.println(MAX-a[w]);
    }
}

