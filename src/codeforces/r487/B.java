package codeforces.r487;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(); int p = in.ni();
        char[] s = in.ns(n);
        boolean possible = false;
        for (int i = 0; i < n-p; i++) {
            if(s[i] == '.'){
                possible = true;
                if(s[i+p] == '.'){
                    s[i] = '1';s[i+p] = '0';
                } else {
                    int d = s[i+p]-'0';
                    s[i] = (char)('0' + (d^1));
                }
                break;
            } else if(s[i+p] == '.') {
                possible = true;
                int d = s[i]-'0';
                s[i+p] = (char)('0' + (d^1));
                break;
            } else if(s[i] != s[i + p]){
                possible = true;
                break;
            }
        }
        if(!possible)
            out.println("No");
        else{
            for (int i = 0; i < n; i++) {
                if(s[i] == '.')
                    s[i] = '0';
            }
            out.println(String.valueOf(s));
        }
    }
}
