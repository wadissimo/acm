package codeforces.ecr32;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        int SIGMA = 26;
        int n = s.length();
        int ans = n;
        for (int i = 0; i < SIGMA; i++) {
            char c = (char)(i+'a');
            int prev = -1;
            int maxDist = 0;
            for (int j = 0; j < n; j++) {
                if(s.charAt(j) == c){
                    maxDist = Math.max(maxDist, j-prev);
                    prev = j;
                }
            }
            maxDist = Math.max(maxDist, n-prev);
            ans = Math.min(ans, maxDist);
        }
        out.println(ans);
    }
}
