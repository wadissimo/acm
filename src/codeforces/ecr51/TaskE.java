package codeforces.ecr51;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;
import java.util.Arrays;

public class TaskE {
    public static int[] z(int[] a){
        int n = a.length;
        int[] z = new int[n];
        int L = 0, R = 0;
        for (int i = 1; i < n; i++) {
            if (i > R) {
                L = R = i;
                while (R < n && a[R - L] == a[R]) R++;
                z[i] = R - L;
                R--;
            } else {
                int k = i - L;
                if (z[k] < R - i + 1) z[i] = z[k];
                else {
                    L = i;
                    while (R < n && a[R - L] == a[R]) R++;
                    z[i] = R - L;
                    R--;
                }
            }
        }
        return z;
    }


    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns(); int ns = s.length();
        String l = in.ns(); int nl = l.length();
        String r = in.ns(); int nr = r.length();
        int[] ar = new int[ns+nr+1];
        int[] al = new int[ns+nl+1];
        for (int i = 0; i < nr; i++) {
            ar[i] = r.charAt(i) - '0';
        }
        for (int i = 0; i < nl; i++) {
            al[i] = l.charAt(i) - '0';
        }
        ar[nr] = -1;
        al[nl] = -1;
        for (int i = 0; i < ns; i++) {
            ar[nr+1+i] = s.charAt(i)-'0';
            al[nl+1+i] = s.charAt(i)-'0';
        }
        int[] z = z(ar);
        boolean[] lr = new boolean[ns];
        Arrays.fill(lr, true);
        int zi = nr+1;
        for (int i = 0; i < ns-nr+1; i++, zi++) {
            if(z[zi] < nr){
                lr[i] = ar[z[zi]] > ar[zi];
            }
        }
        z = z(al);
        boolean[] gl = new boolean[ns];
        zi = nl+1;
        for (int i = 0; i < ns-nl+1; i++, zi++) {
            if(z[zi] < nl){
                gl[i] = al[z[zi]] < al[zi];
            } else {
                gl[i] = true; // equals
            }
        }
        long mod = 998244353 ;
        long[] dp = new long[ns+1];
        long[] suffix = new long[ns+1];
        suffix[ns] = dp[ns] = 1;
        for (int i = ns-1; i >=0; i--) {
            suffix[i] = suffix[i+1];
            int from = i+nl;
            if(!gl[i]) from ++;
            if(from > ns) continue;
            int to = i+nr;
            if(!lr[i]) to--;
            if(to<from) continue;
            if(to > ns) to = ns;
            if(s.charAt(i) == '0'){
                if("0".equals(l)){
                    from = to = i+1;
                } else
                    continue;
            }
            dp[i] = suffix[from];
            if(to < ns)
                dp[i] -= suffix[to+1];
            dp[i] = (dp[i] + mod)%mod;
            suffix[i] = (suffix[i] + dp[i])%mod;
        }
        out.println(dp[0]);
    }
}
