package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int cnt = 0;
        for (int i = 1; i < n; i++) {
            if(a[i] == 3 && a[i-1] == 2 || a[i] == 2 && a[i-1] == 3) {
                out.println("Infinite");
                return;
            }
            if(a[i] == 1 && a[i-1] == 3 || a[i] == 3 && a[i-1] == 1) {
                cnt += 4;
            } else if(a[i] == 1 && a[i-1] == 2 || a[i] == 2 && a[i-1] == 1) {
                cnt += 3;
            }
            if(i > 1 && a[i] == 2 && a[i-1] == 1 && a[i-2] == 3)
                cnt--;
        }
        out.println("Finite");
        out.println(cnt);
    }
}
