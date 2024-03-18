package codeforces.r547;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Deque;
import java.util.LinkedList;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        String t = in.ns();
        int CNT = 27;
        Deque<Integer>[] left = new Deque[CNT];
        Deque<Integer>[] right = new Deque[CNT];
        for (int i = 0; i < CNT; i++) {
            left[i] = new LinkedList<>();
            right[i] = new LinkedList<>();
        }
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '?')
                left[CNT-1].offer(i);
            else
                left[s.charAt(i)-'a'].offer(i);
            if(t.charAt(i) == '?')
                right[CNT-1].offer(i);
            else
                right[t.charAt(i)-'a'].offer(i);
        }
        int cnt = 0;
        for (int i = 0; i < CNT - 1; i++) {
            cnt += Math.min(left[i].size(), right[i].size());
        }
        int leftAny = left[CNT-1].size();
        int rightAny = right[CNT-1].size();
        cnt = Math.min(n, cnt + leftAny + rightAny);
        out.println(cnt);
        for (int i = 0; i < CNT - 1; i++) {
            while(!left[i].isEmpty() && !right[i].isEmpty())
                out.printf("%d %d%n", left[i].pop()+1, right[i].pop()+1);
        }
        int lefti = 0, righti = 0;
        while(!left[CNT-1].isEmpty() && righti < CNT){
            while(righti < CNT && right[righti].isEmpty()){
                righti++;
            }
            if(righti < CNT)
                out.printf("%d %d%n", left[CNT-1].pop()+1, right[righti].pop()+1);
        }
        while(!right[CNT-1].isEmpty() && lefti < CNT){
            while(lefti < CNT && left[lefti].isEmpty()){
                lefti++;
            }
            if(lefti < CNT)
                out.printf("%d %d%n", left[lefti].pop()+1, right[CNT-1].pop()+1);
        }
    }
}
