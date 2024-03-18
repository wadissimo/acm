package codeforces.r555;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.ni(), k = in.ni();
        if(k == 1){
            out.println("YES");
            out.println(n);
            return;
        }
        long min = k*(k+1)/2;
        if(n < min){
            out.println("NO");
        } else {
            n -= min;
            long add = n/k;
            int from = (int)(k-n%k);
            long[] ans = new long[(int)k];
            for (int i = 0; i < k; i++) {
                ans[i] = i+1 + add + (i < from?0:1);
            }
            if(ans[1] > ans[0]*2){
                if(k <= 3){
                    out.println("NO");
                    return;
                }
                ans[1]--;
                ans[(int)k-1]++;
            }
//            System.out.println("Arrays.toString(ans) = " + Arrays.toString(ans));
            out.println("YES");
            for (int i = 0; i < k; i++) {
                out.print(ans[i] + " ");
            }
        }
    }
}
