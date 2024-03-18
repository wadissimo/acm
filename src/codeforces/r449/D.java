package codeforces.r449;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni(), c = in.ni();
        int[] state = new int[n];
        for (int i = 0; i < m; i++) {
            int p = in.ni();
            if(p <= c/2){
                int idx = 0;
                while(idx < n && state[idx] != 0 && state[idx] <= p){
                    idx++;
                }
                if(idx == n)
                    return;
                state[idx] = p;
                out.println(idx+1);
                out.flush();
            } else {
                int idx = n-1;
                while(idx >= 0 && state[idx] != 0 && state[idx] >= p){
                    idx--;
                }
                if(idx == -1)
                    return;
                state[idx] = p;
                out.println(idx+1);
                out.flush();
            }

            //check
            boolean res = true;
            for (int j = 1; j < n; j++) {
                if(state[j] == 0 || state[j-1] == 0 || state[j] < state[j-1]){
                    res = false;
                    break;
                }
            }
            if(res)
                return;
        }
    }
}
