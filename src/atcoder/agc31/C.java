package atcoder.agc31;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class C {
    int first;
    int last;
    int[][] g;
    int n;
    LinkedList<Integer> ans;
    boolean[] used;
    boolean dfs(int v){
        for (int u : g[v]) {
            if(!used[u]){
                if(u == last){
                    ans.addFirst(u);
                    ans.addFirst(v);
                    return true;
                }
                if(dfs(u)){
                    ans.addFirst(v);
                    return true;
                }
            }
        }
        return false;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        n = in.ni();
        first = in.ni();
        last = in.ni();
        g = new int[1<<n][n];
        for (int i = 0; i < 1 << n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = i^(1<<j);
            }
        }
        used = new boolean[1<<n];
        used[first] = true;
        ans = new LinkedList<>();
        if(dfs(first)){
            out.println("YES");
            for (Integer num : ans) {
                out.print(num + " ");
            }
            out.println();
        } else {
            out.println("NO");
        }
    }
}
