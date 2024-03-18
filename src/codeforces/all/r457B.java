package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.PriorityQueue;

public class r457B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long n = in.nl();
        int k = in.ni();
        if(Long.bitCount(n) > k){
            out.println("No");
        } else {
            out.println("Yes");
            long [] cnt = new long[121];
            for (int i = 0; i < 61; i++) {
                if((n&(1L<<i)) > 0){
                    cnt[i+60] = 1;
                    k--;
                }
            }
            for (int i = 120; i > 0 && k > 0 ; i--) {
                if(cnt[i] != 0){
                    if(cnt[i] <= k){
                        cnt[i-1] += cnt[i]*2;
                        k-=cnt[i];
                        cnt[i] = 0;
                    } else {
                        break;
                    }
                }
            }
            int min = 0;
            for (int i = 0; i < 121; i++) {
                if(cnt[i] != 0){
                    min = i;
                    break;
                }
            }
            if(k>0) {
                cnt[min--]--;
            }
            for (int i = 120; i >= 0; i--) {
                for (int j = 0; j < cnt[i]; j++) {
                    out.print((i-60) + " ");
                }
            }
            min-=60;
            while (k > 0) {
                out.print(min + " ");
                k--;
                if(k == 0){
                    out.println(min);
                    break;
                }
                min--;
            }

        }
    }
}
