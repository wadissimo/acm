package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class BRGBBoxes {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int R = in.ni(), G = in.ni(), B = in.ni(), N = in.ni();
        int ans = 0;
        for (int r = 0; r*R <= N; r++) {
            for (int g = 0; g*G + r*R <= N ; g++) {
                if((N-g*G-r*R)%B == 0)
                    ans++;
            }
        }
        out.println(ans);
    }
}
