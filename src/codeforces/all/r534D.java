package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class r534D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        int MAX = 1_000_000_000;
        while("start".equals(s)){
            int from = 0, to = 1;
            while(to <= MAX){
                out.printf("? %d %d%n", from, to);
                out.flush();
                String res = in.ns();
                if("x".equals(res))
                    break;
                from = to;
                to *= 2;
            }
            if(to > MAX)
                to = MAX;
            int left = from, right = to;
            while(left < right-1){
                int mid = (left+right+1)/2;
                out.printf("? %d %d%n", left, mid);
                out.flush();
                String res = in.ns();
                if("x".equals(res)){
                    right = mid;
                } else {
                    left = mid;
                }
            }
            out.printf("! %d%n", right);
            out.flush();
            s = in.ns();
        }
    }
}
