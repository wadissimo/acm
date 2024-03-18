package codeforces.ecr58;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class C {
    class Seg{
        int l, r, id;

        public Seg(int l, int r, int id) {
            this.l = l;
            this.r = r;
            this.id = id;
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni();
            Seg [] seg = new Seg[n];
            for (int i = 0; i < n; i++) {
                seg[i] = new Seg(in.ni(), in.ni(), i);
            }
            Arrays.sort(seg, new Comparator<Seg>() {
                @Override
                public int compare(Seg o1, Seg o2) {
                    return Integer.compare(o1.l, o2.l);
                }
            });
            Stack<Integer> right = new Stack<>();
            right.push(seg[0].r);
            int[] ans = new int[n];
            ans[seg[0].id] = 1;
            boolean found = false;
            for (int i = 1; i < n; i++) {
                int l = seg[i].l;
                while(!right.isEmpty() && right.peek() < l)
                    right.pop();
                if(right.isEmpty()){
                    found = true;
                    break;
                }
                right.push(seg[i].r);
                ans[seg[i].id] = 1;
            }
            if(!found){
                out.println(-1);
            } else {
                for (int i = 0; i < n; i++) {
                    if (ans[i] == 1) {
                        out.print("1 ");
                    } else
                        out.print("2 ");
                }
                out.println();
            }
        }
    }
}
