package codeforces.r477;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.TreeSet;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni(), cl = in.ni(), ce = in.ni(), v = in.ni();
        TreeSet<Integer> l = new TreeSet<>();
        TreeSet<Integer> e = new TreeSet<>();

        for (int i = 0; i < cl; i++) {
            l.add(in.ni()-1);
        }
        for (int i = 0; i < ce; i++) {
            e.add(in.ni()-1);
        }


        int q = in.ni();
        for (int i = 0; i < q; i++) {
            int x = in.ni()-1, y = in.ni()-1, xt = in.ni()-1, yt = in.ni()-1;

            int ans = Integer.MAX_VALUE;
            if(x == xt){
                ans = Math.abs(yt-y);
            } else {
                Integer leftl = l.lower(y);
                Integer lefte = e.lower(y);
                Integer rightl = l.higher(y);
                Integer righte = e.higher(y);
                if (leftl != null) {
                    ans = Math.min(ans, y - leftl + Math.abs(xt - x) + Math.abs(yt - leftl));
                }
                if (rightl != null) {
                    ans = Math.min(ans, rightl-y + Math.abs(xt - x) + Math.abs(yt - rightl));
                }
                if (lefte != null) {
                    ans = Math.min(ans, y - lefte + Math.abs(xt - x)/v + (Math.abs(xt - x)%v == 0?0:1)+ Math.abs(yt - lefte));
                }
                if (righte != null) {
                    ans = Math.min(ans, righte - y + Math.abs(xt - x)/v + (Math.abs(xt - x)%v == 0?0:1)+ Math.abs(yt - righte));
                }
            }
            out.println(ans);
        }
    }
}
