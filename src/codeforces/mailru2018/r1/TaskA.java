package codeforces.mailru2018.r1;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int x = in.ni();
        int y = in.ni();
        int z = in.ni();
        int t1 = in.ni();
        int t2 = in.ni();
        int t3 = in.ni();
        if(Math.abs(z-x)*t2+t3*3+Math.abs(x-y)*t2 > Math.abs(x-y)*t1){
            out.println("NO");
        }else{
            out.println("YES");
        }
    }
}
