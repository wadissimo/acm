package codeforces.lyft2018;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int ax = in.ni();
        int ay = in.ni();
        int bx = in.ni();
        int by = in.ni();
        int cx = in.ni();
        int cy = in.ni();
        bx -= ax;
        by -= ay;
        cx -= ax;
        cy -= ay;
        bx = bx > 0?1:-1;
        by = by > 0?1:-1;
        cx = cx > 0?1:-1;
        cy = cy > 0?1:-1;
        if(cx ==bx && cy == by){
            out.println("YES");
        }else {
            out.println("NO");
        }
    }
}
