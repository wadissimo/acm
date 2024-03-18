package codeforces.r553;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class D {
    class Pair{
        int a, b;
        int dif;

        public Pair(int a, int b) {
            this.a = a;
            this.b = b;
            dif = a-b;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++) {
            pairs[i] = new Pair(in.ni(), in.ni());
        }
        Arrays.sort(pairs, (a,b)->(-Integer.compare(a.dif, b.dif)));
        long res = 0;
        for (int i = 0; i < n; i++) {
            res += (long)pairs[i].a*i + (long)pairs[i].b*(n-i-1);
        }
        out.println(res);
    }
}
