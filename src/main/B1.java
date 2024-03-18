package main;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class B1 {

    private boolean check(long[] p, long[] q, long time) {
        int qidx = 0;
        for (int i = 0; i < p.length; i++) {
            long timeRem = time;
            long pos = p[i];
            while(qidx < q.length && Math.abs(pos-q[qidx]) <= timeRem){ // ignore S for now....
                timeRem -= Math.abs(pos-q[qidx]);
                long newPos = q[qidx];
                qidx++;
                while(qidx < q.length && q[qidx] <= pos){ // remove other visited on the way left
                    qidx++;
                }
                pos = newPos;
            }
            if(qidx == q.length)
                break;
        }
        if(qidx < q.length)
            return false;
        else
            return true;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {


            int N = in.ni(), M = in.ni(), K = in.ni(), S = in.ni();
            long[] p = new long[N];
            for (int i = 0; i < K; i++) {
                p[i] = in.ni();
            }
            long AP = in.ni(), BP = in.ni(), CP = in.ni(), DP = in.ni();
            long[] q = new long[M];
            for (int i = 0; i < K; i++) {
                q[i] = in.ni();
            }
            long AQ = in.ni(), BQ = in.ni(), CQ = in.ni(), DQ = in.ni();
            for (int i = K; i < N; i++) {
                p[i] = ((AP*p[i-2] + BP*p[i-1]+ CP)%DP) +1;
            }
            for (int i = K; i < M; i++) {
                q[i] = ((AQ*q[i-2] + BQ*q[i-1]+ CQ)%DQ) +1;
            }
            Random rand = new Random();
            for (int i = 0; i < M; i++) {
                long tmp = q[i];
                int idx = rand.nextInt(M);
                q[i] = q[idx];
                q[idx] = tmp;
            }
            for (int i = 0; i < N; i++) {
                long tmp = p[i];
                int idx = rand.nextInt(N);
                p[i] = p[idx];
                p[idx] = tmp;
            }
            Arrays.sort(q);
            Arrays.sort(p);
            long left = 0, right = 2_000_007;
            while(left < right){
                long mid = (left+right)/2;
                if(check(p,q, mid)){
                    right = mid;
                } else {
                    left = mid+1;
                }
            }
            out.printf("Case #%d: %d%n", t + 1, left);

        }
    }
}
