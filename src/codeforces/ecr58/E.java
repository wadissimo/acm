package codeforces.ecr58;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int q = in.ni();
        int maxx = 0;
        int maxy = 0;
        for (int i = 0; i < q; i++) {
            String s = in.ns();
            if(s.charAt(0) == '+'){
                int x = in.ni(), y = in.ni();
                if(x < y){
                    int t = x;
                    x = y;
                    y = t;
                }
                maxx = Math.max(maxx, x);
                maxy = Math.max(maxy, y);
            } else {
                int h = in.ni(), w = in.ni();
                if(h < w){
                    int t = h;
                    h = w;
                    w = t;
                }
                if(maxx <= h && maxy<=w){
                    out.println("YES");
                } else
                    out.println("NO");
            }
        }
    }
}
