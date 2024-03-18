package atcoder.agc31;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        long mod = (int)1e9 + 7;
        int[] cnt = new int[26];
        long ans = 0;
        for (int i = 0; i < n; i++) {
            int d = s.charAt(i)-'a';
            long res = 1;
            for (int j = 0; j < 26; j++) {
                if(j ==d) continue;
                res = res*(cnt[j]+1)%mod;
            }
            ans = (ans + res)%mod;
            cnt[d]++;
        }
        out.println(ans);
    }
}
