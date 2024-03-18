package codeforces.all;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class r458C {
    int[] dp;

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        dp = new int[1001];
        for (int num = 2; num <= 1000; num++) {
            dp[num] = dp[Integer.bitCount(num)]+1;             
        }
        String s = in.ns();
        int k = in.ni();
        if(k == 0){
            out.println(1);
            return;
        }
        int n = s.length();
        if(n <= 10 && Integer.parseInt(s, 2) <= 1000){
            int ans = 0;
            for (int num = 1; num <= Integer.parseInt(s, 2); num++) {
                if(dp[num] == k)
                    ans += 1;
            }
            out.println(ans);
        } else {
            /*int test = 0;
            for (int i = 2; i <= Long.parseLong(s, 2); i++) {
                if(dp[Long.bitCount(i)] == k-1) {
                    test++;
                    System.out.println("i = " + i);
                    System.out.println("Long.bitCount(i) = " + Long.bitCount(i));
                }
            }
            System.out.println("test = " + test);
*/
            long mod = (int)1e9+7;
            long[][] C = IntegerUtils.pascal_triangle_modulo(n + 7, mod);
            long res = 0;
            List<Integer> toProcess = new LinkedList<>();
            for (int i = 1; i < Math.min(1000, n); i++) {
                if(dp[i] == k-1) {
                    toProcess.add(i);
                    res = (res + C[n-1][i])%mod;
                }
            }
            if(toProcess.isEmpty()){
                out.println(0);
                return;
            }
            int cnt1 = 1;
            int len = n-1;
            for (int i = 1; i < n; i++, len--) {
                if(s.charAt(i) == '0')
                    continue;
                for(int num: toProcess) {
                    if(num >= cnt1 && num-cnt1 <= len-1)
                        res = (res + C[len-1][num-cnt1])%mod;
                }
                cnt1++;
            }
            if(k == 1)
                res = (res-1+mod)%mod;
            if(dp[cnt1] == k-1)
                res = (res +1)%mod;
            out.println(res);
        }
    }
}
