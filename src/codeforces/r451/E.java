package codeforces.r451;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.Arrays;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        long[] a = in.nal(n);
        boolean[] sq = new boolean[n];
        long[] makeSq = new long[n];
        long[] makeNSq = new long[n];
        int sqCnt = 0;
        for (int i = 0; i < n; i++) {
            sq[i] = IntegerUtils.isPerfectSquare(a[i]);
            if(sq[i]){
                makeNSq[i] = a[i] == 0 ? 2:1;
                sqCnt++;
            } else {
                long root = IntegerUtils.root2(a[i]);
                makeSq[i] = Math.min(a[i] - root*root, (root+1)*(root+1)-a[i]);
            }
        }
        if(sqCnt == n/2){
            out.println(0);
        } else if(sqCnt < n/2){
            Long[] ord = new Long[n-sqCnt];
            int oi = 0;
            for (int i = 0; i < n; i++) {
                if(!sq[i]){
                    ord[oi++] = makeSq[i];
                }
            }
            Arrays.sort(ord);
            long sum = 0;
            for (int i = 0; i < n / 2 - sqCnt; i++) {
                sum += ord[i];
            }
            out.println(sum);
        } else {
            Long[] ord = new Long[sqCnt];
            int oi = 0;
            for (int i = 0; i < n; i++) {
                if(sq[i]){
                    ord[oi++] = makeNSq[i];
                }
            }
            Arrays.sort(ord);
            long sum = 0;
            for (int i = 0; i < sqCnt-n/2; i++) {
                sum += ord[i];
            }
            out.println(sum);
        }
    }
}
