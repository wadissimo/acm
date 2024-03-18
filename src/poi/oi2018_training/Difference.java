package poi.oi2018_training;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class Difference {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        char[] s = in.ns(n);
        int best = 0;
        for (int i = 0; i < 26; i++) {
            for (int j = 0; j < 26; j++) {
                if(i!=j){
                    char maxC = (char)('a' + i);
                    char minC = (char)('a' + j);
                    int minCnt = 0;
                    int maxCnt = 0;
                    boolean startsWithMin = false;
                    for (int k = 0; k < n; k++) {
                        if(s[k] == maxC){
                            maxCnt++;
                            if(startsWithMin && minCnt > 1){
                                best = Math.max(best, maxCnt - minCnt +1);
                            } else if(minCnt > 0)
                                best = Math.max(best, maxCnt-minCnt);
                        } else if(s[k] == minC){
                            minCnt++;
                            if(maxCnt-minCnt < 0) {
                                maxCnt = 0;
                                minCnt = 1;
                                startsWithMin = true;
                            }
                        }
                    }
                }
            }
        }
        out.println(best);

    }
}
