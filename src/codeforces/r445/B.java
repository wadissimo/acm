package codeforces.r445;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int MAX = 200_007;
        int[] last = new int[MAX];
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            last[a[i]] = Math.max(last[a[i]], i);
        }
        int min = MAX;
        int ans = 0;
        for (int i = 0; i < MAX; i++) {

            if(last[i] != -1){
                if(last[i] < min){
                    min = last[i];
                    ans = i;
                }
            }
        }
        out.println(ans);

    }
}
