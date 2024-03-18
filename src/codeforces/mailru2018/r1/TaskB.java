package codeforces.mailru2018.r1;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int curMax = -1;

        for (int i = 0; i < n; i++) {
            if(a[i] > curMax+1){
                out.println(i+1);
                return;
            }
            curMax = Math.max(curMax, a[i]);
        }
        out.println(-1);
    }
}
