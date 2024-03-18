package main;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.Map;
import java.util.TreeMap;

public class TaskF {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0)+1);
        }
        int idx = 0;
        int M = map.size();

        int[] cnt = new int[M];
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            cnt[idx] = entry.getValue();
            map.put(entry.getKey(), idx);
            idx++;
        }

        long mod = 998244353;
        long[] invs = IntegerUtils.invs(n + 1, mod);
        long[][] dp = new long[M+1][M+1];
        for (int i = 0; i < M; i++) {
            dp[0][i] = invs[n]*cnt[i]%mod;
        }
        long ans = 0;
        for (int i = 0; i < M; i++) {
            long sum = 0;
            for (int num = 0; num < M; num++) {
                if(cnt[num] > 1){
                    ans = (ans + (cnt[num]-1)*invs[n-i-1]%mod*dp[i][num]%mod)%mod;// win
                }
                dp[i+1][num] = sum*cnt[num]%mod;
                sum = (sum + dp[i][num]*invs[n-i-1]%mod)%mod;
            }
        }
        out.println(ans);

    }
}
