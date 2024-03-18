package codejam.year2008.r1c;

import chelper.io.FastScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class A {
    public static void main(String[] args) throws FileNotFoundException {
//                FastScanner in = new FastScanner(System.in);
//        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner(A.class.getResourceAsStream("A-large-practice.in"));
        PrintWriter out = new PrintWriter(new File("/home/vadim/dev/tmp/A.out"));
        int N = in.ni();
        for (int n = 0; n < N; n++) {
            int p = in.ni(), k = in.ni(), l = in.ni();
            int[] f = in.na(l);
            Arrays.sort(f);
            long ans = 0;
            long sum = 0;
            int mult = 1;
            for (int i = 0; i < l; i++) {
                sum += f[l-1-i];
                if(i%k == k-1 || i == l-1){
                    ans += sum*mult;
                    sum = 0;
                    mult++;
                }
            }
            out.printf("Case #%d: %d%n", n+1, ans);
        }
        out.flush();
        out.close();

    }
}
