package codeforces.r517;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int w = in.ni();
        int h = in.ni();
        int k = in.ni();
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans+=(w-4*i-1)*2+(h-4*i-1)*2;
        }
        out.println(ans);
    }
}
