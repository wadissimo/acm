package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;

public class r466E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), c = in.ni();
        int[] a = in.na(n);
        Deque<Integer> deq = new LinkedList<Integer>();
        if(c == 1 || n == 1){
            out.println(0);
            return;
        }
        long sum = 0;
        long[] dp = new long[n];
        for (int i = 0; i < n; i++) {
            sum += a[i];
            while(!deq.isEmpty() && deq.peekFirst() > a[i]) {
                deq.pop();
            }
            deq.push(a[i]);
            if(i >= c){
                if(deq.peekLast() == a[i-c])
                    deq.removeLast();
            }
            if(i>=c-1) {
                dp[i] = dp[i-1];
                if(i>=c)
                    dp[i] = Math.max(dp[i], dp[i-c] + deq.peekLast());
                else
                    dp[i] = deq.peekLast();
            }
        }
        out.println(sum - dp[n-1]);

    }
}
