package codeforces.r538;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class B {

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni(), k = in.ni();
        int[] a = in.na(n);
        Integer []ord = new Integer[n];
        for (int i = 0; i < n; i++) {
            ord[i] = i;
        }
        Arrays.sort(ord, (x,y)->Integer.compare(a[x], a[y]));
        long sum = 0;
        boolean[] take = new boolean[n];
        for (int i = n-k*m; i < n; i++) {
            sum+=a[ord[i]];
            take[ord[i]] = true;

        }
        out.println(sum);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if(take[i]){
                cnt++;
                if(cnt == m && k > 1){
                    k--;
                    out.print((i+1)+ " ");
                    cnt = 0;
                }
            }
        }
        out.println();
    }
}
