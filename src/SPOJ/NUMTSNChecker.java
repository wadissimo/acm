package SPOJ;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class NUMTSNChecker {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int a = in.ni();
        int b = in.ni();
        int ans = 0;
        for (int i = a; i <= b; i++) {
            String s = Integer.toString(i);
            int n3=0,n6=0,n9=0;
            for (int j = 0; j < s.length(); j++) {
                if(s.charAt(j) == '3')
                    n3++;
                else if(s.charAt(j) == '6')
                    n6++;
                else if(s.charAt(j) == '9')
                    n9++;
            }
            if(n3>0&&n3==n6&&n3==n9)
                ans++;

        }
        out.println(ans);
    }
}
