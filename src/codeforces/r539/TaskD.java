package codeforces.r539;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskD {
    String s;
    int n;
    boolean checkPoly(int from, int to){
        for (int i = 0; i < (to-from+1)/2 ; i++) {
            if(s.charAt(from + i) != s.charAt(to-i))
                return false;
        }
        return true;
    }
    boolean sim(int from, int len){
        for (int i = 0; i < len; i++) {
            if(s.charAt(from + i) != s.charAt(from + len + i))
                return false;
        }
        return true;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        s = in.ns();
        n = s.length();
        boolean impossible = true;
        for (int i = 1; i < n/2; i++) {
            if(s.charAt(i) != s.charAt(0)) {
                impossible = false;
                break;
            }
        }
        if(impossible){
            out.println("Impossible");
            return;
        }
        for (int i = 1; i <= n/2; i++) {
            if(checkPoly(0, i*2-1) && !sim(0, i)&&(i*2 >= n-1 || checkPoly(i*2, n-1))){
                //System.out.println("i = " + i);
                out.println(1);
                return;
            }
        }
        out.println(2);
    }
}
