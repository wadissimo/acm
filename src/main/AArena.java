package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class AArena {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int N = in.ni();
            int min = 101;
            int cnt = 0;
            for (int i = 0; i < N; i++) {
                int a = in.ni();
                if(a < min) {
                    cnt = 1;
                    min = a;
                } else if(a == min){
                    cnt ++;
                }
            }
            out.println(N-cnt);
        }
    }
}
