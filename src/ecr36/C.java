package ecr36;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {

    int[] ans;
    String sa;
    String sb;
    int [] cnt;
    boolean go(int i, int max, boolean maxed){
        if(i>=sa.length())
            return true;
        if(maxed)
            max = 9;
        else
            max = sb.charAt(i)-'0';
        for(int j = max; j>= 0; j--){
            if(cnt[j] > 0){
                ans[i] = j;
                cnt[j]--;
                if(j < max)
                    maxed = true;
                boolean res = go(i+1, max, maxed);
                if(res)
                    return true;
                else
                    cnt[j]++;
            }
        }
        return false;
    }

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long a = in.nl();
        long b = in.nl();
        sa = Long.toString(a);
        sb = Long.toString(b);

        cnt = new int[10];
        for (int i = 0; i < sa.length(); i++) {
            int d = sa.charAt(i)-'0';
            cnt[d]++;
        }
        boolean maxed = false;
        if(sb.length() > sa.length())
            maxed = true;
        ans = new int[sa.length()];

        boolean res = go(0, 9, maxed);
        if(!res)
            throw new RuntimeException("Invalid");

        for(int aa: ans){
            out.print(aa);
        }
        out.println();
    }
}
