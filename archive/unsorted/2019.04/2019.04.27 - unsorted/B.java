package codeforces.r443;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        long k = in.nl();
        int[]a = in.na(n);
        if(k >= n){
            int max = 0;
            for (int i = 0; i < n; i++) {
                max = Math.max(max, a[i]);
            }
            out.println(max);
        } else {
            LinkedList<Integer> list = new LinkedList<>();
            for (int i = 0; i < n; i++) {
                list.addLast(a[i]);
            }
            int[] win = new int[n+1];
            int cur = list.pollFirst();
            while(true){
                int next = list.pollFirst();
                if(cur > next){
                    win[cur]++;
                    list.addLast(next);
                } else {
                    list.addLast(cur);
                    cur = next;
                    win[cur] = 1;
                }
                if(win[cur] >= k){
                    out.println(cur);
                    break;
                }
            }
        }
    }
}
