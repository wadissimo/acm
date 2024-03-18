package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class ATelefonniiNomer {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int N = in.ni();
            String s = in.ns();
            boolean good = false;
            for (int i = 0; i <= N - 11; i++) {
                if(s.charAt(i) == '8'){
                    good = true;
                }
            }
            out.println(good?"YES":"NO");
        }
    }
}
