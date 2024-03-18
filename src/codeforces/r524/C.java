package codeforces.r524;

import chelper.io.FastScanner;
import java.io.PrintWriter;

import static java.lang.Math.abs;
import static java.lang.Math.max;
import static java.lang.Math.min;

public class C {
    long[] cnt(long a, long b, long c, long d){//white black
        long sum = (abs(a-c)+1)*(abs(d-b)+1);
        long black = sum/2;
        if(sum%2 == 1 && a%2 != b%2){
            black ++;
        }
        return new long[]{sum-black, black};
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            long n = in.ni(), m = in.ni();
            long x1 = in.ni(), y1 = in.ni(), x2 = in.ni(), y2 = in.ni();
            long x3 = in.ni(), y3 = in.ni(), x4 = in.ni(), y4 = in.ni();

            long sum = n*m;
            long black = sum/2;
            long white = sum-black;

            long xc1 = max(x1, x3);
            long yc1 = max(y1, y3);
            long xc2 = min(x2, x4);
            long yc2 = min(y2, y4);
            if(xc1 <= xc2 && yc1 <= yc2){
                //System.out.printf("case %d intersects %d %d %d %d%n",t+1, xc1, yc1, xc2, yc2);
                long[] cnt1 = cnt(x1, y1, x2, y2);
                long[] cnt2 = cnt(x3, y3, x4, y4);
                long[] cnt3 = cnt(xc2, yc2, xc1, yc1);
                black-=cnt1[1]+cnt2[1]-cnt3[1];
                white-=cnt1[0]+cnt2[0]-cnt3[0];
                white += (x2-x1+1)*(y2-y1+1) - (xc2-xc1+1)*(yc2-yc1+1);
                black += (x4-x3+1)*(y4-y3+1);
            } else {
                long[] cnt1 = cnt(x1, y1, x2, y2);
                long[] cnt2 = cnt(x3, y3, x4, y4);
                black-=cnt1[1]+cnt2[1];
                white-=cnt1[0]+cnt2[0];
                black += (x4-x3+1)*(y4-y3+1);
                white += (x2-x1+1)*(y2-y1+1);
            }
            out.printf("%d %d%n", white, black);
        }
    }
}
