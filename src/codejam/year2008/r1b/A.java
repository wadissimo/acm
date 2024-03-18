package codejam.year2008.r1b;

import chelper.io.FastScanner;
import codejam.year2008.r1a.A1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.math.BigInteger;

public class A {
    public static void main(String[] args) throws FileNotFoundException {
//        FastScanner in = new FastScanner(System.in);
//        PrintWriter out = new PrintWriter(System.out);
        FastScanner in = new FastScanner(A.class.getResourceAsStream("A-large-practice.in"));
        PrintWriter out = new PrintWriter(new File("/home/vadim/dev/tmp/A.out"));
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni();
            long a = in.nl(), b = in.nl(), c = in.nl(), d = in.nl(), x0 = in.nl(), y0 = in.nl(), m = in.nl();
            long x = x0, y = y0;
            int[][] cnt = new int[3][3];
            cnt[(int)x%3][(int)y%3]++;
            for (int i = 0; i < n - 1; i++) {
                x = (a*x+b)%m;
                y = (c*y + d)%m;
//                int xc = ((int)x%3 +3)%3;
//                int yc = ((int)y%3 +3)%3;
                cnt[(int)x%3][(int)y%3]++;
            }
            BigInteger[][] CNT = new BigInteger[3][3];
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    CNT[i][j] = BigInteger.valueOf(cnt[i][j]);
                }
            }
            BigInteger TWO = BigInteger.valueOf(2);
            BigInteger SIX = BigInteger.valueOf(6);
            BigInteger ans = BigInteger.ZERO;
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(cnt[i][j] >= 3)
                        ans = ans.add(CNT[i][j].multiply(CNT[i][j].subtract(BigInteger.ONE).multiply(CNT[i][j].subtract(TWO))).divide(SIX));
                }
                if(cnt[i][0] > 0 && cnt[i][1] > 0 && cnt[i][2] > 0)
                    ans = ans.add(CNT[i][0].multiply(CNT[i][1]).multiply(CNT[i][2]));
                if(cnt[0][i] > 0 && cnt[1][i] > 0 && cnt[2][i] > 0)
                    ans = ans.add(CNT[0][i].multiply(CNT[1][i]).multiply(CNT[2][i]));
                if(cnt[0][i] > 0 && cnt[1][(i+1)%3] > 0 && cnt[2][(i+2)%3] > 0)
                    ans = ans.add(CNT[0][i].multiply(CNT[1][(i+1)%3]).multiply(CNT[2][(i+2)%3]));
                if(cnt[0][i] > 0 && cnt[1][(i+2)%3] > 0 && cnt[2][(i+1)%3] > 0)
                    ans = ans.add(CNT[0][i].multiply(CNT[1][(i+2)%3]).multiply(CNT[2][(i+1)%3]));
            }
            out.printf("Case #%d: %d%n", t+1, ans);
        }
        out.flush();
        out.close();
    }
}
