package codeforces.ecr58;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        int b1 = s.indexOf('[');
        int b2 = s.lastIndexOf(']');
        int ans = -1;
        if(b1 != -1 && b2 != -1 && b1 < b2){
            int s1 = s.indexOf(':', b1);
            int s2 = s.lastIndexOf(':', b2);
            if(s1 != -1 && s2 != -1 && s1<s2){
                ans = 4;
                for (int i = s1; i < s2; i++) {
                    if(s.charAt(i) == '|')
                        ans++;
                }
            }
        }
        out.println(ans);
    }
}
