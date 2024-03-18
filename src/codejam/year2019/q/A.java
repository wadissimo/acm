package codejam.year2019.q;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            String s = in.ns();
            StringBuilder a = new StringBuilder();
            StringBuilder b = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i) == '4'){
                    a.append('2');b.append('2');
                }else{
                    a.append(s.charAt(i));
                    if(b.length() != 0)
                        b.append('0');
                }
            }
            out.printf("Case #%d: %s %s%n", t+1, a.toString(), b.toString());
        }
    }
}
