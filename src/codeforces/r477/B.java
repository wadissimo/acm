package codeforces.r477;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), a = in.ni(), b = in.ni();
        int s1 = in.ni();
        int[] s = in.na(n-1);
        Arrays.sort(s);
        int lim = s1*a/b;
        int sum = s1;
        int res = n-1;
        for (int i = 0; i < n - 1; i++) {
            sum += s[i];
            if(sum > lim)
                break;
            res--;
        }
        out.println(res);


    }
}
