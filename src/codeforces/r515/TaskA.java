package codeforces.r515;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int L=in.ni();int v = in.ni();int l=in.ni();int r = in.ni();
            int c1 = (l-1)/v;
            int c2 = L/v-r/v;
            out.println(c2+c1);
        }


    }
}
