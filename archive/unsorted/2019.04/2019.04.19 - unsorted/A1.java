package codeforces.r459;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A1 {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        char[] ca = s.toCharArray();
        int n = ca.length;
        int ans = 0;
        boolean[][] left = new boolean[n][n];
        for (int start = 0; start < n; start++) {
            int free = 0, close = 0, open = 0;
            for (int i = start; i < n; i++) {
                if(ca[i] == '('){
                    open++;
                } else if(ca[i] == ')')
                    close++;
                else
                    free++;
                if(close-open > free)
                    break;
                if((i-start+1)%2 == 0){
                    left[start][i] = true;
                }
            }
        }
        for (int start = n-1; start >= 0; start--) {
            int free = 0, close = 0, open = 0;
            for (int i = start; i >= 0; i--) {
                if(ca[i] == '('){
                    open++;
                } else if(ca[i] == ')')
                    close++;
                else
                    free++;
                if(open-close > free)
                    break;
                if((start-i+1)%2 == 0 && left[i][start]){
                    ans++;
                }
            }
        }

        out.println(ans);
    }
}
