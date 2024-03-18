package codeforces.neerc2018.finals;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class F {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] divs = new int[5000];
        int di = 0;
        for (int div = 2; div*div <= n; div++) {
            if(n%div == 0){
                divs[di++] = div;
            }
        }
        for (int i = di-1; i >=0; i--) {
            int div = divs[i];
            if(div*div != n){
                divs[di++] = n/div;
            }
        }
        int c = n-1;
        boolean found = false;
        for (int i = 0; i < di && !found; i++) {
            for (int j = i+1; j < di && !found; j++) {
                if(IntegerUtils.gcd(divs[i], divs[j]) == 1){
                    int a = divs[i], b = divs[j];
                    long[]x = new long[2];
                    IntegerUtils.gcdExt(a, b, x);
                    x[0] *= c;
                    x[1] *= c;
                    if(x[0] > 0){
                        x[1] += x[0]/b*a;
                        x[0] -= x[0]/b*b;
                    } else {
                        x[0] += x[1]/a*b;
                        x[1] -= x[1]/a*a;
                    }
                    if(x[0] >= 0 && x[1] >= 0){

                        int b1 = n/a;
                        int b2 = n/b;
                        long k = (x[0] + b1 - 2)/(b1-1) + (x[1] + b2 - 2)/(b2-1);
                        if(k > 100_000){
                            found = false;
                            continue;
                        }
                        out.println("YES");
                        out.println(k);
                        for (int l = 0; l < x[0] / (b1 - 1); l++) {
                            out.printf("%d %d%n", b1-1, b1);
                        }
                        if(x[0] %(b1-1) > 0)
                            out.printf("%d %d%n", x[0]%(b1-1), b1);
                        for (int l = 0; l < x[1] / (b2 - 1); l++) {
                            out.printf("%d %d%n", b2-1, b2);
                        }
                        if(x[1] %(b2-1) > 0)
                            out.printf("%d %d%n", x[1]%(b2-1), b2);
                        //check
                        if(a*x[0] + b*x[1] != c)
                            throw new RuntimeException("assert");
                        return;

                    }
                }
            }
        }
        out.println("NO");

    }
}
