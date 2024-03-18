package codeforces.r491;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.math.BigInteger;

public class TaskEBF {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int digs[] = new int[10];
        String s = Integer.toString(n);
        for (int i = 0; i < s.length(); i++) {
            digs[s.charAt(i)-'0'] += 1;
        }
        long max = BigInteger.valueOf(10).pow(s.length()).longValue() - 1;
        int ans = 0;
        int used[] = new int[10];
        for (int num = 1; num <= max; num++) {
            s = Integer.toString(num);
            boolean possible = true;
            System.arraycopy(digs, 0, used, 0, 10);
            for (int i = 0; i < s.length(); i++) {
                used[s.charAt(i) - '0']--;
            }
            for (int i = 0; i < 10; i++) {
                if(used[i] < 0 || used[i] == digs[i] && digs[i] > 0)
                    possible = false;
            }
            if(possible) {
                //System.out.println(num);
                ans++;
            }
        }
        out.println(ans);
    }
}
