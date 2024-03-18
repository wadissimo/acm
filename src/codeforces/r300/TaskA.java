package codeforces.r300;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        String s = in.readLine();
        String c = "CODEFORCES";
        int l = 0;
        for (int i = 0; i < Math.min(s.length(), c.length()); i++) {
            if(s.charAt(i) != c.charAt(i))    {
                break;
            }
            l++;
        }
        s = new StringBuffer(s).reverse().toString();
        c = new StringBuffer(c).reverse().toString();
        int r = 0;
        for (int i = 0; i < Math.min(s.length(), c.length()); i++) {
            if(s.charAt(i) != c.charAt(i))    {
                break;
            }
            r++;
        }
        if(l+r>=10) {
            out.println("YES");
        } else {
            out.println("NO");
        }
    }
}
