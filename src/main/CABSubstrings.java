package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class CABSubstrings {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni();
        int ba = 0, xa = 0, bx = 0;
        int ans = 0;
        for (int i = 0; i < N; i++) {
            String s = in.ns();
            for (int j = 1; j < s.length(); j++) {
                if(s.charAt(j-1) == 'A' && s.charAt(j) == 'B')
                    ans++;
            }
            int n = s.length();
            char first = s.charAt(0);
            char last = s.charAt(n-1);
            if(first == 'B' && last == 'A'){
                ba++;
            } else if(first == 'B'){
                bx++;
            } else if(last == 'A'){
                xa++;
            }
        }

        if(ba > 0){
            ans+= ba-1;
            ba = 1;
        }
        if(ba > 0 && xa > 0 && bx > 0){
            ba = 0; xa--;bx--;
            ans+=2;
        }
        int cnt = Math.min(xa, bx);
        ans += cnt;
        xa -= cnt; bx -= cnt;
        if(ba > 0 && (xa > 0 || bx > 0)){
            ans++;
        }
        out.println(ans);
    }
}
