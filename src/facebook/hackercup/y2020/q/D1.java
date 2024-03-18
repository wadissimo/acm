package facebook.hackercup.y2020.q;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;

public class D1 {
    class Solution{
        int idx;
        long c;

        public Solution(int idx, long c) {
            this.idx = idx;
            this.c = c;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int N = in.ni();
            int M = in.ni();
            long [] C = new long[N];
            for (int i = 0; i < N; i++) {
                C[i] = in.ni();
            }
            C[0] = 0;
            Deque<Solution> sols = new LinkedList<>();
            sols.addLast(new Solution(N-1, 0));
            boolean possible = true;
            for (int i = N-2; i >=0 ; i--) {
                while(!sols.isEmpty() && sols.getFirst().idx > i+M)
                    sols.removeFirst();
                if(sols.isEmpty()){
                    possible = false;
                    break;
                }
                if(C[i] == 0)
                    continue;
                long cost = C[i] + sols.getFirst().c;
                Solution sol = new Solution(i, cost);
                while(!sols.isEmpty() && sols.getLast().c >= cost)
                    sols.removeLast();
                sols.addLast(sol);
            }
            out.printf("Case #%d: ", t+1);
            if(!possible || sols.isEmpty()){
                out.println(-1);
            } else {
                out.println(sols.getFirst().c);
            }
        }
    }
}
