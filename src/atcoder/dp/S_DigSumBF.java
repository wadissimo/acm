package atcoder.dp;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class S_DigSumBF {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int k = in.ni();
        int d = in.ni();
        int ans = 0;
        for (int i = 1; i <= k; i++) {
            String s = Integer.toString(i);
            int sum = 0;
            for (int j = 0; j < s.length(); j++) {
                sum+=(s.charAt(j)-'0');
            }
            if(sum%d == 0)
                ans++;
        }
        out.println(ans);

    }
}
