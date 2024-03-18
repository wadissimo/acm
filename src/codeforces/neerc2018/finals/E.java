package codeforces.neerc2018.finals;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class E {
    String cell(int r, int x){
        return "" + (char)('a'+(x-1)) + Integer.toString(r) +  " ";
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int rpos = 1, xpos = 1;
        int start = 1, end = 2;
        out.print("a1 ");
        for (int row = 1; row < 8; row++) {
            if(n == 2){
                rpos = 8;
                out.print(cell(rpos, xpos));
                n--;
                break;
            }
            for (int x = 3; x <= 8 && n > 3; x++) {
                xpos = x;
                out.print(cell(row, xpos));
                n--;
            }
            xpos = end;
            out.print(cell(row, xpos));
            n--;
            if(n == 2){
                rpos = 8;
                out.print(cell(rpos, xpos));
                n--;
                break;
            }
            rpos++;
            out.print(cell(rpos, xpos));
            n--;
            end = start;
            start = xpos;
        }

        if(n > 1){
            xpos = (xpos == 1)?2:1;
            out.print(cell(rpos, xpos));
            n--;
            for (int x = 3; x <= 7 && n > 1; x++) {
                xpos = x;
                out.print(cell(rpos, xpos));
                n--;
            }
        }
        out.println(cell(8,8));
        n--;

    }
}
