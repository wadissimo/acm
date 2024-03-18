package codeforces.r451;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;

public class D {
    class Alarm{
        int id, a;

        public Alarm(int id, int a) {
            this.id = id;
            this.a = a;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni(), k = in.ni();

        int MAX = 1000_003;
        LinkedList<Alarm>[] all = new LinkedList[MAX];
        for (int i = 0; i < MAX; i++) {
            all[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            Alarm alarm = new Alarm(i, in.ni());
            all[alarm.a].add(alarm);
        }
        Deque<Alarm> dq = new LinkedList<>();
        int ans = 0;
        for (int i = 1; i <=m ; i++) {
            if(all[i].isEmpty())
                continue;
            for (Alarm alarm : all[i]) {
                if(dq.size() < k-1){
                    dq.addLast(alarm);
                } else {
                    ans ++;
                }
            }
        }
        for (int i = m+1; i <= 1000_000; i++) {
            while(!dq.isEmpty() && dq.peekFirst().a == i-m)
                dq.pollFirst();
            for (Alarm alarm : all[i]) {
                if(dq.size() < k-1){
                    dq.addLast(alarm);
                } else {
                    ans ++;
                }
            }
        }
        out.println(ans);
    }
}
