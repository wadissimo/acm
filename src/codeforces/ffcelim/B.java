package codeforces.ffcelim;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        String s = in.ns();
        StringBuilder sb = new StringBuilder();
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) != 'a')
                sb.append(s.charAt(i));
            else cnt++;
        }
        if(sb.length() == 0){
            out.println(s);
            return;
        }
        int n = sb.length()/2;
        String wrong = ":(";
        if(sb.length()%2 != 0 ){
            out.println(wrong);
            return;
        }


        String t = sb.toString();
        for (int i = 0; i < n; i++) {
            if(t.charAt(i) != t.charAt(i+n) || s.charAt(s.length()-i-1) == 'a'){
                out.println(wrong);
                return;
            }
        }


        s = s.substring(0, s.length()-n);
        out.println(s);
    }
}
