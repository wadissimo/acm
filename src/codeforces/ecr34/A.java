package codeforces.ecr34;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        for (int t = 0; t < n; t++) {
            int x = in.ni();
            boolean yes = false;
            for (int i = 0; i <= x / 7; i++) {
                if((x-i*7)%3 == 0){
                    out.println("YES");
                    yes = true;
                    break;
                }
            }
            if(!yes)
                out.println("NO");
        }
    }
}
