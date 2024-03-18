package codeforces.r543;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;

public class C {
    class Sol{
        int a;
        int id;
        int start, end;

        public Sol(int a, int id) {
            this.a = a;
            this.id = id;
        }
        void init(int start){
            this.start = start;
            this.end = start+a;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        int[] a = in.na(n);
        Sol[] sol = new Sol[n];
        for (int i = 0; i < n; i++) {
            sol[i] = new Sol(a[i], i);
        }
        PriorityQueue<Sol> pq = new PriorityQueue<>(new Comparator<Sol>() {
            @Override
            public int compare(Sol o1, Sol o2) {
                return Integer.compare(o1.end, o2.end);
            }
        });
        int cur = 0;
        int[] cnt = new int[150_007];
        for (cur = 0; cur < Math.min(k, n); cur++) {
            sol[cur].init(0);
            pq.offer(sol[cur]);
            cnt[sol[cur].end]++;
        }

        for(;cur<n;cur++){
            Sol s = pq.poll();
            sol[cur].init(s.end);
            cnt[sol[cur].end]++;
            pq.offer(sol[cur]);
        }
        int[] d = new int[150_007];
        int total = 0;
        for (int i = 1; i < 150_007; i++) {
            d[i] = d[i-1];
            if(cnt[i] > 0){
                total += cnt[i];
                d[i] = (int)Math.round(100.0*total/(double)n);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int test = 1; test <= sol[i].a ; test++) {
                if(d[sol[i].start+test-1] == test){
                    ans ++;
                    break;
                }
            }
        }
        out.println(ans);

    }
}
