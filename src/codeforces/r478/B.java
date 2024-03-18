package codeforces.r478;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int[] a = in.na(14);
        long ans = 0;
        for (int start = 0; start < 14; start++) {
            int[] b = Arrays.copyOf(a, 14);
            int num = a[start];
            b[start] = 0;
            for (int i = 0; i < 14; i++) {
                b[i] += num/14;
            }
            int rem = num%14;
            for (int i = 1; i <= 14 && rem > 0; i++) {
                int pos = (start+i)%14;
                b[pos] ++;
                rem--;
            }
            long sum = 0;
            for (int i = 0; i < 14; i++) {
                if(b[i] %2 == 0)
                    sum+= b[i];
            }
            ans = Math.max(ans, sum);
        }
        out.println(ans);
    }
}
