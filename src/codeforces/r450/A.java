package codeforces.r450;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int left = 0, right = 0;
        for (int i = 0; i < n; i++) {
            int x = in.ni(), y = in.ni();
            if(x > 0)
                right++;
            else
                left++;
        }
        if(left <=1 ||right <=1)
            out.println("Yes");
        else
            out.println("No");
    }
}
