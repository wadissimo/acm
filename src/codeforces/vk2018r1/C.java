package codeforces.vk2018r1;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class C {

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        long[] v = in.nal(n);
        long[] t = in.nal(n);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long pref = 0;
        for (int i = 0; i < n; i++) {
            pq.offer(pref + v[i]);
            long ans = 0;
            while(pq.size() > 0 && pq.peek() <= pref + t[i]){
                ans += pq.poll() - pref;
            }
            ans+=pq.size()*t[i];
            out.print(ans + " ");
            pref+=t[i];
        }
    }
}
