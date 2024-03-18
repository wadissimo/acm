package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class FallingBalls {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int N = in.ni();
            int[] a = in.na(N);
            int sum = 0;
            for (int i = 0; i < N; i++) {
                sum += a[i];
            }
            if(sum != N || a[0] == 0 || a[N-1] == 0){
                out.printf("Case #%d: IMPOSSIBLE%n", t+1);
                continue;
            }
            int[] dist = new int[N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if(a[j] != 0){
                        a[j]--;
                        dist[i] = j;
                        break;
                    }
                }
            }
//            System.out.println("Arrays.toString(dist) = " + Arrays.toString(dist));
            int ans = 0;
            List<String> res = new LinkedList<>();
            int[] next = new int[N];
            while(true){
                for (int i = 0; i < N; i++) {
                    next[i] = i;
                }
                boolean finished = true;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < N; i++) {
                    if(dist[i] == i){
                        sb.append('.');
                        next[i] = i;
                    } else if(dist[i] > i) {
                        sb.append('\\');
                        next[i+1] = dist[i];
                        finished = false;
                    } else {
                        next[i-1] = dist[i];
                        sb.append('/');
                        finished = false;
                    }
                }
                res.add(sb.toString());
                ans++;
                if(finished)
                    break;
                for (int i = 0; i < N; i++) {
                    dist[i] = next[i];
                }
            }
            out.printf("Case #%d: %d%n", t+1, ans);
            for (String str : res) {
                out.println(str);
            }
        }
    }
}
