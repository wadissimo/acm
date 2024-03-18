package codeforces.r555;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        char[] chars = in.ns().toCharArray();
        int[] p = new int[10];
        for (int i = 0; i < 9; i++) {
            p[i+1] = in.ni();
        }
        for (int i = 0; i < n; i++) {
            int d = chars[i]-'0';
            if(p[d] > d){
                for (int j = i; j < n; j++) {
                    d = chars[j]-'0';
                    if(p[d] < d)
                        break;
                    chars[j] = (char)('0' + p[d]);
                }
                break;
            }
        }
        out.println(new String(chars));

    }
}
