package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class vkr2_2018 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] ind = new int[n+1];
        Arrays.fill(ind, -1);
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
            if(ind[a[i]+1] == -1){
                ind[a[i]+1] = i;
            }
        }
        //System.out.println("Arrays.toString(ind) = " + Arrays.toString(ind));
        int[] b = new int[n];
        for (int i = n; i > 0 ; i--) {
            if(ind[i] != -1){
                b[ind[i]] = i;
                if(ind[i-1] == -1 || ind[i-1] > ind[i]-1)
                    ind[i-1] = ind[i]-1;
            }
        }
        int cnt = 0;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            cnt = Math.max(cnt, b[i]);
            ans += cnt-1-a[i];
        }
        out.println(ans);


    }
}
