package codeforces.neerc2018.finals;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class L {
    class P implements Comparable<P>{
        int id, job, b;

        public P(int id, int job, int b) {
            this.id = id;
            this.job = job;
            this.b = b;
        }

        @Override
        public int compareTo(P o) {
            return Integer.compare(b, o.b);
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        int[]a = in.na(n);
        int[]b = in.na(n);
        int[] maxi = new int[k+1];
        int[] max = new int[k+1];
        P[] ps = new P[n];
        Arrays.fill(maxi, -1);
        for (int i = 0; i < n; i++) {
            ps[i] = new P(i, a[i], b[i]);
            if(max[a[i]] < b[i]){
                max[a[i]] = b[i];
                maxi[a[i]] = i;
            }
        }
        Arrays.sort(ps);
        int rem = 0;
        for (int i = 1; i < k + 1; i++) {
            if(maxi[i] == -1){
                rem++;
            }
        }
        long ans = 0;
        for (P p : ps) {
            if(rem == 0){
                break;
            }
            if(maxi[p.job] == p.id)
                continue;
            ans += p.b;
            rem--;
        }
        out.println(ans);

    }
}
