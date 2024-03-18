package codeforces.avito2018.cool;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            c[i] = n-1 -a[i];
        }
        int[] ans = new int[n];
        int cur = 1;
        int[] cnt = new int[n];
        int[] hat = new int[n];
        //System.out.println(Arrays.toString(c));
        for (int i = 0; i < n; i++) {
            if(c[i] == 0){
                ans[i] = cur;
                cur++;
            } else{
                if(cnt[c[i]] == 0){
                    hat[c[i]] = cur;
                    ans[i] = cur;
                    cur++;
                    cnt[c[i]] = c[i];
                } else{
                    ans[i] = hat[c[i]];
                    cnt[c[i]]--;
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if(cnt[i] != 0){
                out.println("Impossible");
                return;
            }
        }
        out.println("Possible");
        for (int i = 0; i < n; i++) {
            out.print(ans[i] + " ");
        }
        out.println();
    }
}
