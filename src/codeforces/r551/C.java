package codeforces.r551;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        int open = 0, close = 0, q = 0;
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '(')
                open++;
            else if(s.charAt(i) == ')')
                close++;
            else q++;
        }
        int d = close-open;
        if((q+d) %2 != 0 || (q-d)%2 != 0){
            out.println(":(");
            return;
        }
        int x = (q+d)/2;
        int y = (q-d)/2;
        open = close = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if(s.charAt(i) == '('){
                open++;
                sb.append('(');
            } else if(s.charAt(i) == ')'){
                close++;
                sb.append(')');
            } else {
                if(x > 0){
                    x--;
                    open++;
                    sb.append('(');
                } else {
                    y--;
                    close++;
                    sb.append(')');
                }
            }
            if(close > open || open == close && i < n-1) {
                out.println(":(");
                return;
            }
        }
        if(close != open) {
            out.println(":(");
            return;
        } else {
            out.println(sb.toString());
        }

    }
}
