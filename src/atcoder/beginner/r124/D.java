package atcoder.beginner.r124;

import chelper.io.FastScanner;
import common.Treap;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class D {
    class Segment{
        int cnt;
        int val;
        Segment next;

        public Segment(int cnt, int val) {
            this.cnt = cnt;
            this.val = val;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        String s = in.ns();
        Segment root = null;
        Segment last = null;
        int cnt = 1;
        for (int i = 1; i <= n; i++) {
            if(i == n || s.charAt(i) != s.charAt(i-1)){
                Segment seg = new Segment(cnt, s.charAt(i-1)-'0');
                if(root == null){
                    last = root = seg;
                } else {
                    last.next = seg;
                    last = seg;
                }
                cnt = 0;
            }
            cnt++;
        }
        int kk = 0;
        int len = 0;
        int max = 0;
        Segment cur = root;
        Segment tail = cur;
        while(cur != null){
            if(cur.val == 0)
                kk++;
            len += cur.cnt;
            if(kk > k){
                if(tail.val == 1){
                    len -= tail.cnt;
                    tail = tail.next;
                    kk--;
                    len -= tail.cnt;
                    tail = tail.next;
                } else {
                    len -= tail.cnt;
                    tail = tail.next;
                    kk--;
                }
            }
            max = Math.max(max, len);
            cur = cur.next;
        }
        out.println(max);

    }
}
