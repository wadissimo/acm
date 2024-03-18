package codeforces.r531;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        boolean[][] cols = new boolean[5007][k];
        int[] ans = new int[n];
        int[] a = in.na(n);
        boolean correct = true;

        for (int i = 0; i < k; i++) {
            ans[i] = i+1;
            cols[a[i]][i] = true;
        }
        for (int i = k; i < n; i++) {
            int ind = -1;
            for (int j = 0; j < k; j++) {
                if(!cols[a[i]][j]){
                    ind = j;
                    break;
                }
            }
            if(ind == -1){
                correct = false;
                break;
            }
            cols[a[i]][ind] = true;
            ans[i] = ind+1;
        }

        if(!correct){
            out.println("NO");
        }else{
            out.println("YES");
            for (int i = 0; i < n; i++) {
                out.print(ans[i] + " ");
            }
            out.println();
        }

    }
}
