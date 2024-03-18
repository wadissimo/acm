package codeforces.ecr57;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        long pref = 0;
        long suf = 0;
        int first = s.charAt(0);
        int last = s.charAt(n-1);
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == first)
                pref++;
            else
                break;
        }
        for (int i = n-1; i >=0; i--) {
            if(s.charAt(i) == last)
                suf++;
            else
                break;
        }
        if(first != last){
            out.println(suf+pref+1);
        } else{
            out.println(((suf+1)*(pref+1))%998244353 );
        }
    }
}
