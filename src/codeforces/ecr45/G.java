package codeforces.ecr45;

import chelper.io.FastScanner;

import java.io.PrintWriter;
import java.util.*;

public class G {
    boolean[] used;
    List<Integer>[] g;
    int[][] divs;
    int[] a;
    int[][] dp;
    long[] ans;
    private void dfs(int v){
        dp[v] = new int[divs[a[v]].length];
        Arrays.fill(dp[v], 1);
        for (int u : g[v]) {
            if(!used[u]){
                used[u] = true;
                dfs(u);
                for (int dv = 0; dv < divs[a[v]].length; dv++) {
                    int div = divs[a[v]][dv];
                    if(a[u]%div == 0) {
                        int du = Arrays.binarySearch(divs[a[u]], divs[a[v]][dv]);
                        if (du >= 0) {
                            ans[div] += dp[u][du] * (long)dp[v][dv];
                            dp[v][dv] += dp[u][du];
                        }
                    }
                }
            }
        }
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        a = in.na(n);
        divs = new int[200007][];
        dp = new int[n][];
        int []curdivs = new int[200];
        int cn = 0;
        for (int num = 1; num < 200007; num++) {
            int div = 1;
            cn = 0;
            for (; div*div < num ; div++) {
                if(num%div == 0){
                    curdivs[cn++] = div;
                    curdivs[cn++] = num/div;
                }
            }
            if(div*div == num)
                curdivs[cn++] = div;
            Arrays.sort(curdivs, 0, cn);
            divs[num] = Arrays.copyOf(curdivs, cn);
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

        ans = new long[200007];
        used = new boolean[n];
        used[0] = true;
        dfs(0);

        for (int i = 200003; i > 1; i--) {
            if(ans[i] != 0) {
                int div = 1;
                for (; div*div < i; div++) {
                       if(i%div == 0){
                           ans[div] -= ans[i];
                           if(div != 1)
                                ans[i/div] -= ans[i];
                       }
                }
                if(div*div == i){
                    ans[div] -= ans[i];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            ans[a[i]]++;
        }
        for (int i = 0; i < 200003; i++) {
            if(ans[i] != 0)
                out.println(i + " " + ans[i]);
        }
    }
}
