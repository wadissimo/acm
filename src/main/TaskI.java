package main;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;
import java.util.Arrays;

public class TaskI {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        int[] a = in.na(n);
        ArrayUtils.randomShuffle(a);
        Arrays.sort(a);
        if(k == 1){
            out.println(0);
            return;
        }

        int left = 0, right = a[n-1]-a[0];
        while(left<right){
            int mid = (left+right)/2;
            int i = -1;
            int[] dp = new int[n+1];
            dp[0] = 1;
            int[] pref = new int[n+3];
            for (int j = 0; j < n; j++) {
                pref[j+1] = pref[j]+dp[j];
                while(a[j]-a[i+1] > mid)
                    i++;
                if(i <= j-k){
                    if(pref[j-k+2] > pref[i+1]){
                        dp[j+1] = 1;
                    }
                }
            }
            if(dp[n] != 1){
                left = mid+1;
            } else{
                right = mid;
            }
        }
        out.println(left);
//        int[] from = new int[n+1];
//        int INF = 1_000_000_007;
//        Arrays.fill(dp, INF);
//        dp[0] = 0;
//        from[0] = -1;
//        for (int i = k; i <= n; i++) {
//            if(dp[i-1] == INF) {
//                dp[i] = Math.max(dp[i - k], a[i - 1] - a[i-k]);
//                from[i] = i-k;
//            } else if(dp[i-k] == INF){
//                dp[i] = Math.max(dp[i-1], a[i-1]-a[from[i-1]]);
//                from[i] = from[i-1];
//            } else {
//                int start = Math.max(dp[i - k], a[i - 1] - a[i-k]);
//                int cont = Math.max(dp[i-1], a[i-1] - a[from[i-1]]);
//                if(start <= cont){
//                    dp[i] = start;
//                    from[i] = i-k;
//                } else {
//                    dp[i] = cont;
//                    from[i] = from[i-1];
//                }
//            }
//        }
//        out.println(dp[n]);
    }
}
