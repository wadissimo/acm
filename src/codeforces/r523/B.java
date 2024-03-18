package codeforces.r523;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        int[] a = in.na(n);
        if(n==1){
            out.println(0);
            return;
        }
        Arrays.sort(a);
        long ans = 0;
        int cur = a[n-1];
        for (int i = n-2; i >=0 ; i--) {
            if(a[i] < cur){
                ans += a[i];
                cur = a[i];
            } else {
                ans += cur-1;
                if(cur>1)
                    cur--;
                ans += a[i]-cur;
            }
            //System.out.println(ans);
        }
        out.println(ans);


    }
}
