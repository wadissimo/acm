package codeforces.neerc2018.finals;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class G {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int k = in.ni();
            int[] a = in.na(7);
            int sum = 0;
            int[] ind = new int[8];
            int ii= 1;
            for (int i = 0; i < 7; i++) {
                if(a[i] != 0){
                    ind[ii++] = i;
                }
                sum += a[i];
            }
            int ans = Integer.MAX_VALUE;

            for (int start = 0; start < 7; start++) {
                if(a[start] == 0)
                    continue;
                int rem = k;
                int days = 0;
                days += 7*(rem/sum -1);
                rem -= (rem/sum -1)*sum;
                for (int i = start; i < 21 && rem > 0; i++) {
                    days++;
                    if(a[i%7] == 1){
                        rem--;
                    }
                }
                if(rem!=0){
                    throw new RuntimeException("assert");
                }
                ans = Math.min(ans, days);
            }
            out.println(ans);

        }
    }
}
