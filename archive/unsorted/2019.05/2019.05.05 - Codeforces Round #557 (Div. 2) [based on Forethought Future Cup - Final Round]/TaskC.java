package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni(), K = in.ni();
        int[] x = new int[K];
        boolean[] have = new boolean[N];
        for (int i = 0; i < K; i++) {
            int xx = in.ni()-1;
            x[i] = xx;
            have[xx] = true;
        }
        int[] first = new int[N];
        int[] last = new int[N];
        Arrays.fill(first, -1);
        Arrays.fill(last, -1);
        for (int i = 0; i < K; i++) {
            if(first[x[i]] == -1)
                first[x[i]] = i;
            last[x[i]] = i;
        }
        int ans = 0;
        for (int i = 0; i < N; i++) {
            if(!have[i])
                ans++;
            if(!have[i] && i > 0)
                ans++;
            if(!have[i] && i < N-1)
                ans++;
            if(have[i]){
                if(i > 0){
                    if(!have[i-1] || first[i] > last[i-1])
                        ans++;
                }
                if(i < N-1){
                    if(!have[i+1] || first[i] > last[i+1])
                        ans++;
                }
            }
        }
        out.println(ans);

    }
}
