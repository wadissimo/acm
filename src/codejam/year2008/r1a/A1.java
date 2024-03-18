package codejam.year2008.r1a;

import chelper.io.FastScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;

public class A1 {
    public static void main(String[] args) throws FileNotFoundException {
        FastScanner in = new FastScanner(A1.class.getResourceAsStream("A-large-practice.in"));
        PrintWriter out = new PrintWriter(new File("/home/vadim/dev/tmp/A.out"));
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni();
            int[] a = in.na(n);
            int[] b = in.na(n);
            Arrays.sort(a);Arrays.sort(b);
            long res = 0;
            for (int i = 0; i < n; i++) {
                res += (long)a[i]*b[n-i-1];
            }
            out.printf("Case #%d: %d%n", t+1, res);
        }
        out.flush();
        out.close();
    }
}
