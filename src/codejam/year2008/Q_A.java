package codejam.year2008;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class Q_A {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int s = in.ni();
            String [] engines = new String[s];
            for (int i = 0; i < s; i++) {
                engines[i] = in.readLine();
            }
            int Q = in.ni();
            int[] query = new int[Q];
            for (int i = 0; i < Q; i++) {
                String str = in.readLine();
                for (int j = 0; j < s; j++) {
                    if(str.equals(engines[j])){
                        query[i] = j;
                        break;
                    }
                }
            }
            int INF = 1_000_000;
            int ans = 0;
            int next = 0;
            int cur = -1;
            while(next < INF){
                int best = 0;
                int bestEngine = -1;
                for (int i = 0; i < s; i++) {
                    if(i == cur)
                        continue;
                    int j = next+1;
                    for (; j < Q; j++) {
                        if(query[j] == i){
                            if(j > best){
                                best = j;
                                bestEngine = i;
                                break;
                            }
                            break;
                        }
                    }
                    if(j==Q){
                        next = INF;
                        break;
                    }
                }
                if(next == INF)
                    break;
                ans++;
                next = best;
                cur = bestEngine;
            }
            out.printf("Case #%d: %d%n", t+1,  ans);
        }
    }
}
