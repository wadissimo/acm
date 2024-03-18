package codejam.year2008.r1b;

import chelper.io.FastScanner;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class C {
    public static void main(String[] args) throws FileNotFoundException {
//                        FastScanner in = new FastScanner(System.in);
//        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner(B.class.getResourceAsStream("C-large-practice.in"));
        PrintWriter out = new PrintWriter(new File("/home/vadim/dev/tmp/C.out"));
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int k = in.ni();
            int n = in.ni();
            int[] da = in.na(n);
            out.printf("Case #%d: ", t+1);
            for (int d : da) {
                int rem = k;
                int pos = 0;
                for (int i = 0; i < k; i++) {
                    pos = (pos+i)%rem;
                    if(pos == d-1) {
                        out.print((i+1) + " ");
                        break;
                    }else if(pos < d-1)
                        d--;
                    rem--;
                }
            }
            out.println();
        }
        out.flush();
        out.close();

    }
}
