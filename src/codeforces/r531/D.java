package codeforces.r531;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        int[] cnts = new int[3];
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int dig = s.charAt(i)-'0';
            cnts[dig]++;
            ans[i] = dig;
        }
        int bal = n/3;
        boolean[] less = new boolean[3];
        boolean[] more = new boolean[3];
        for (int i = 0; i < 3; i++) {
            if(cnts[i] < bal)
                less[i] = true;
            if(cnts[i] > bal)
                more[i] = true;
        }
        for (int d = 0; d < 2; d++) {
            if (less[d]) {
                for (int i = 0; i < n; i++) {
                    if (ans[i] > d && more[ans[i]]) {
                        cnts[ans[i]]--;
                        if (cnts[ans[i]] <= bal) {
                            more[ans[i]] = false;
                        }
                        ans[i] = d;
                        cnts[d]++;
                        if (cnts[d] >= bal) {
                            less[d] = false;
                            break;
                        }
                    }
                }
            }
        }
        for (int d = 2; d >=1; d--) {
            if(less[d]){
                for (int i = n-1; i >=0 ; i--) {
                    if(ans[i] != d && more[ans[i]]){
                        cnts[ans[i]]--;
                        if (cnts[ans[i]] <= bal) {
                            more[ans[i]] = false;
                        }
                        ans[i] = d;
                        cnts[d]++;
                        if (cnts[d] >= bal) {
                            less[d] = false;
                            break;
                        }
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            out.print(ans[i]);
        }
        out.println();
    }
}
