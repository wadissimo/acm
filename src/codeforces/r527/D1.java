package codeforces.r527;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class D1 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, a[i]);
        }
        int[] c = new int[n];
        for (int i = 0; i < n; i++) {
            if((max-a[i])%2 == 1)
                c[i] = 1;
        }
        int cnt = 1;
        int[] st = new int[n];
        int si = 0;
        for (int i = 1; i <= n; i++) {
            if(i<n && c[i] == c[i-1])
                cnt++;
            else{
                if(cnt%2 == 1){
                    if(si>0 && st[si-1] == c[i-1]){
                        si--;
                    } else{
                        st[si++] = c[i-1];
                    }
                }
                cnt = 1;
            }
        }
        if(si>1){
            out.println("NO");
        } else{
            out.println("YES");
        }
    }
}
