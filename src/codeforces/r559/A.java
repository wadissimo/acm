package codeforces.r559;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni();
        char[] a = in.ns().toCharArray();
        int cur = 0;
        int min = 0;
        for (int i = 0; i < N; i++) {
            if(a[i] == '+'){
                cur++;
            } else{
                cur--;
            }
            min = Math.min(cur, min);
        }
        out.println(cur-min);
    }
}
