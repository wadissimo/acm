package codeforces.hello2019;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class DSim {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.nl(); int k = in.ni();
        Random rand = new Random();
        long[] divs = new long[100];
        long tot = 0;
        int niter = 100000;
        for (int ns = 0; ns < niter; ns++) {
            long num = n;
            for (int i = 0; i < k; i++) {
                int dn = 0;
                int div = 1;
                for (; div*div < num ; div++) {
                    if(num%div == 0){
                        divs[dn++] = div;
                        divs[dn++] = num/div;
                    }
                }
                if(div*div == num){
                    divs[dn++] = div;
                }
                //System.out.println("Arrays.toString(divs) = " + Arrays.toString(divs));
                num = divs[rand.nextInt(dn)];
            }
            tot += num;
        }
        out.println(tot/(1.0d*niter));


    }
}
