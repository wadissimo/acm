package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskM {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int x = in.ni(), y = in.ni(); int tx = in.ni(), ty = in.ni();
        int dx = Math.abs(x-tx), dy = Math.abs(y-ty);
        if(dx == 0){
            out.println((dy+3)*2);
        } else if(dy == 0){
            out.println((dx+3)*2);
        } else {
            out.println((dx+dy+2)*2);
        }
    }
}
