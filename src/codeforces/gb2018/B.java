package codeforces.gb2018;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int maxx = -10000_007;
        int maxy = -10000_007;
        for (int i = 0; i < n; i++) {
            int x = in.ni(), y = in.ni();
            if(x > maxx){
                maxx = x;
                maxy = y;
            } else if(x == maxx){
                maxy = Math.max(maxy, y);
            }
        }
        int minx = 10000_007;
        int miny = 10000_007;
        for (int i = 0; i < n; i++) {
            int x = in.ni(), y = in.ni();
            if(x < minx){
                minx = x;
                miny = y;
            } else if(x == minx){
                miny = Math.min(miny, y);
            }
        }
        out.printf("%d %d%n", maxx+minx, maxy+miny);
    }
}
