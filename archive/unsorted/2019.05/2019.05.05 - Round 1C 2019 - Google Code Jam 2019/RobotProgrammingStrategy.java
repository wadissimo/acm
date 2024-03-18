package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class RobotProgrammingStrategy {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int N = in.ni();
            String[] sa = new String[N];
            int MAXLEN = 500;
            for (int i = 0; i < N; i++) {
                sa[i] = in.ns();
            }
            int[] cur = new int[N];
            boolean[] have = new boolean[3];//R P S
            StringBuilder ans = new StringBuilder();
            boolean[] remove = new boolean[N];
            boolean possible = false;
            for (int i = 0; i < MAXLEN; i++) {
                have[0] = have[1] = have[2] = false;
                for (int j = 0; j < N; j++) {
                    if(remove[j])
                        continue;
                    if(sa[j].charAt(cur[j]) == 'R')
                        have[0] = true;
                    else if(sa[j].charAt(cur[j]) == 'P')
                        have[1] = true;
                    else
                        have[2] = true;

                }
                int cnt = 0;
                for (int j = 0; j < 3; j++) {
                    if(have[j])
                        cnt++;
                }
                if(cnt == 3){
                    possible = false;
                    break;
                } else if(cnt == 1){
                    if(have[0])
                        ans.append('P');
                    else if(have[1])
                        ans.append('S');
                    else ans.append('R');
                    possible = true;
                    break;
                } else {
                    char c;
                    if(!have[0]) {
                        ans.append('S');
                        c = 'P';
                    }else if(!have[1]) {
                        ans.append('R');
                        c = 'S';
                    }else {
                        ans.append('P');
                        c = 'R';
                    }
                    for (int j = 0; j < N; j++) {
                        if(remove[j])
                            continue;
                        if (sa[j].charAt(cur[j]) == c){
                            remove[j] = true;
                            continue;
                        }
                        cur[j]++;
                        if(cur[j] == sa[j].length())
                            cur[j] = 0;
                    }
                }
            }
            if(!possible)
                out.printf("Case #%d: %s%n", t+1, "IMPOSSIBLE");
            else
                out.printf("Case #%d: %s%n", t+1, ans.toString());
        }
    }
}
