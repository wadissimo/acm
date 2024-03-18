package atcoder.dp;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class K_Stones {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        int[] a = in.na(n);
        boolean[] won = new boolean[k+1];
        for (int num = 0; num <=k; num++) {
            if(!won[num]) {
                for (int i = 0; i < n; i++) {
                    if(num+a[i]<=k) {
                        won[num+a[i]] = true;
                    }
                }
            }
        }
        if(won[k]){
            out.println("First");
        } else
            out.println("Second");

    }
}
