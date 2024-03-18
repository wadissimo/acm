package codejam.year2008.r1a;

import chelper.io.FastScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class C {
    public static void main(String[] args) throws FileNotFoundException {
        FastScanner in = new FastScanner(A1.class.getResourceAsStream("C-small-practice.in"));
        PrintWriter out = new PrintWriter(new File("/home/vadim/dev/tmp/C-small.out"));
        long mod = 1000;
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni();
            long a = 3, b = 1;
            while(n>1){
                if(n%2 == 1){
                    a = (3*a + 5*b)%mod;
                    b = (a + 3*b)%mod;
                    n--;
                } else {
                    a = (a*a + 5*b*b)%mod;
                    b = 2*a*b%mod;
                    n/=2;
                }
            }
            out.printf("Case #%d: %d%n",t+1, (2*a+mod-1)%mod);
        }
        out.flush();
        out.close();

    }
}
