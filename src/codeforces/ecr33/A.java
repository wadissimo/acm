package codeforces.ecr33;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int watch = 3;
        for (int i = 0; i < n; i++) {
            int res = in.ni();
            if(res == watch){
                out.println("NO");
                return;
            }

            for (int j = 1; j <=3 ; j++) {
                if(j == res || j == watch)
                    continue;
                watch = j;
                break;
            }
        }
        out.println("YES");
    }
}
