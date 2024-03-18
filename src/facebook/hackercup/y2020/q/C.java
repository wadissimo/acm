package facebook.hackercup.y2020.q;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.*;

public class C {
    class Tree{
        long p, h;

        public Tree(long p, long h) {
            this.p = p;
            this.h = h;
        }
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        Random rand = new Random();
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int N = in.ni();
            Tree[] trees = new Tree[N];
            for (int i = 0; i < N; i++) {
                trees[i] = new Tree(in.ni(), in.ni());
            }
            for (int i = 0; i < N; i++) {
                Tree tt = trees[i];
                int x = rand.nextInt(N);
                trees[i] = trees[x];
                trees[x] = tt;
            }

            Arrays.sort(trees, Comparator.comparingLong(tt -> tt.p));
            TreeMap<Long, Long> leftSols = new TreeMap<>();
            long ans = 0;

            for (int i = N-1; i >= 0 ; i--) {
                Long sol = leftSols.get(trees[i].p);
                long best = trees[i].h;
                if(sol != null){
                    best += sol;
                }
                long coord = trees[i].p - trees[i].h;
                Long leftSol = leftSols.get(coord);
                if(leftSol == null || leftSol <= best){
                    leftSols.put(coord, best);
                }
                ans = Math.max(ans, best);
            }
            TreeMap<Long, Long> rightSols = new TreeMap<>();

            for (int i = 0; i < N; i++) {
                Long sol = rightSols.get(trees[i].p);
                long best = trees[i].h;
                if(sol != null){
                    best += sol;
                }
                long coord = trees[i].p + trees[i].h;
                Long rightSol = rightSols.get(coord);
                if(rightSol == null || rightSol <= best){
                    rightSols.put(coord, best);
                }
                ans = Math.max(ans, best);
                Long leftSol = leftSols.get(coord);
                if(leftSol != null){
                    ans = Math.max(ans, best + leftSol);
                }
            }
            out.printf("Case #%d: ", t+1);
            out.println(ans);
        }
    }
}
