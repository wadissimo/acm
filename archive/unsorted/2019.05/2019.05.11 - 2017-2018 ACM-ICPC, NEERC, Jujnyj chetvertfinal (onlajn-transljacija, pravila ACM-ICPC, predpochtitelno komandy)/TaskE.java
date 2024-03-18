package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskE {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni();
        String s = in.ns();
        int K = in.ni();
        String[] ws = new String[K];
        for (int i = 0; i < K; i++) {
            ws[i] = in.ns();
        }
        int S = 26;
        boolean[] used = new boolean[S];
        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if(c != '*')
                used[c-'a'] = true;
        }
        boolean[] bad = new boolean[K];
        for (int i = 0; i < K; i++) {
            for (int j = 0; j < N; j++) {
                if(s.charAt(j) != '*') {
                    if(s.charAt(j) != ws[i].charAt(j)){
                        bad[i] = true;
                        break;
                    }
                } else {
                    if(used[ws[i].charAt(j)-'a']){
                        bad[i] = true;
                        break;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = 0; i < S; i++) {
            if(!used[i]){
                boolean correct = true;
                for (int j = 0; j < K; j++) {
                    if(bad[j])continue;
                    if(ws[j].indexOf((char)(i+'a')) == -1){
                        correct = false;
                        break;
                    }
                }
                if(correct)
                    ans++;
            }
        }
        out.println(ans);
    }
}
