package codeforces.vk2018r1;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.ArrayList;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int x2 = in.ni();
        int x2_orig = x2;
        int ans = 1_000_001;
        ArrayList<Integer> ps = new ArrayList<>();
        for (int p = 2; p*p <= x2; p++) {
            if(x2%p == 0){
                ps.add(p);
                while(x2%p == 0)
                    x2 /= p;
            }
        }
        if(x2 > 1)
            ps.add(x2);
        for(int p: ps){
            int a = x2_orig/p;
            for (int x1_orig = p*(a-1)+1; x1_orig <= x2_orig; x1_orig++) {
                int x1  = x1_orig;
                for (int q = 2; q*q <= x1; q++) {
                    if(x1 % q == 0){
                        int b = x1_orig/q;
                        int x0 = q * (b - 1) + 1;
                        if(x0 >= 3)
                            ans = Math.min(ans, x0);
                        while(x1%q == 0)
                            x1/=q;
                    }
                }
                if(x1>1){
                    int b = x1_orig/x1;
                    int x0 = x1 * (b - 1) + 1;
                    if(x0 >= 3)
                        ans = Math.min(ans, x0);
                }

            }
        }
        out.println(ans);
    }
}
