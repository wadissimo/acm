package codeforces.ecr63;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        int cnt = 0;
        for (int i = 0; i < n-10; i++) {
            if(s.charAt(i) == '8')
                cnt++;
        }
        int moves = (n-11)/2;
        if(cnt > moves){
            out.println("YES");
        }else{
            out.println("NO");
        }
    }
}
