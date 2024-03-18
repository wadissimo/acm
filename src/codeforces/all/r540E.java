package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class r540E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        int cnt = 0;
        int[][] ans = new int[n][2];
        for (int i = 0; i < k && cnt < n; i++) {
            for (int j = i+1; j < k && cnt < n; j++) {
                ans[cnt][0] = i+1;
                ans[cnt][1] = j+1;
                cnt++;
                if(cnt < n){
                    ans[cnt][0] = j+1;
                    ans[cnt][1] = i+1;
                    cnt++;
                }
            }
        }
        if(cnt < n){
            out.println("NO");
        } else {
            out.println("YES");
            for (int i = 0; i < n; i++) {
                out.printf("%d %d%n", ans[i][0], ans[i][1]);
            }
        }
    }
}
