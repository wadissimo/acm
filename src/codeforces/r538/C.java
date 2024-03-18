package codeforces.r538;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.nl(), b = in.nl();
        long[] divs = new long[50];
        int[] divcnt = new int[50];
        int di = 0;
        for (long div = 2; div*div <= b; div++) {
            if(b%div == 0){
                divs[di++] = div;
                while(b%div == 0){
                    divcnt[di-1]++;
                    b/=div;
                }
            }
        }
        if(b>1){
            divs[di++] = b;
            divcnt[di-1] = 1;
        }
        long min = Long.MAX_VALUE;
        for (int i = 0; i < di; i++) {
            long div = divs[i];
            long pow = div;
            long cnt = n/pow;
            while(pow < n && pow*div > pow){
                pow *=div;
                cnt += n/pow;
            }
            min = Math.min(min, cnt/divcnt[i]);
        }

        out.println(min);
    }
}
