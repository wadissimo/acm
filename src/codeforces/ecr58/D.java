package codeforces.ecr58;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class D {

    boolean[] used;
    List<Integer>[] g;
    int[][] divs;
    int[] a;
    int[][] dp;
    int[][] ans;
    int[] dn;
    private void dfs(int v){
        int[] max = new int[dn[v]];
        int[] max2 = new int[dn[v]];
        for (int u : g[v]) {
            if(!used[u]){
                used[u] = true;
                dfs(u);
                for (int d = 0; d < dn[v]; d++) {
                    for (int du = 0; du < dn[u]; du++) {
                        if(divs[v][d] == divs[u][du]){
                            if(dp[u][du] > max[d]){
                                max2[d] = max[d];
                                max[d] = dp[u][du];
                            } else
                                max2[d] = Math.max(max2[d], dp[u][du]);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < dn[v]; i++) {
            dp[v][i] = max[i]+1;
            ans[v][i] = max[i]+1+max2[i];
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        a = in.na(n);
        ArrayList<Integer> primes = new ArrayList<>();
        int[] lp = new int[200007];
        IntegerUtils.sieve(200003, primes, lp);

        divs = new int[n][10];

        dn = new int[n];
        for (int i = 0; i < n; i++) {
            int num = a[i];
            while(num > 1){
                int div = lp[num];
                while(num%div == 0){
                    num /= div;
                }
                divs[i][dn[i]++] = div;
            }
        }

        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new LinkedList<>();
        }
        for (int i = 0; i < n - 1; i++) {
            int v = in.ni()-1, u = in.ni()-1;
            g[v].add(u);
            g[u].add(v);
        }
        boolean ans0 = true;
        for (int i = 0; i < n; i++) {
            if(a[i] != 1)
                ans0 = false;
        }
        if(ans0){
            out.println(0);
            return;
        }
        dp = new int[n][10];
        ans = new int[n][10];

        used = new boolean[n];
        used[0] = true;
        dfs(0);
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 10; j++) {
                res = Math.max(ans[i][j], res);
            }
        }
        out.println(res);

    }
}
