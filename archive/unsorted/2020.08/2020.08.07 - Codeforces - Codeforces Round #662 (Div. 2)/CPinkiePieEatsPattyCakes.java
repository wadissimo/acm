package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class CPinkiePieEatsPattyCakes {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni();
            int MAX = 100_007;
            int[] freq = new int[MAX];
            int maxFreq = 0;
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = in.ni();
                freq[a[i]]++;
                maxFreq = Math.max(maxFreq, freq[a[i]]);
            }
            int cntMax = 0;
            for (int i = 0; i < MAX; i++) {
                if(freq[i] == maxFreq)
                    cntMax++;
            }
            int rem = n - cntMax*maxFreq;
            int minGap = rem / (maxFreq-1);
            minGap += cntMax -1;
            out.println(minGap);

        }
    }
}
