package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class CMahmoudAndAMessage {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        String s = in.ns();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = s.charAt(i)-'a';
        }
        int S = 26;
        int[] lens = in.na(S);
        int[] maxLen = new int[n];
        for (int start = 0; start < n; start++) {
            int last = n;
            for (int i = start; i < n; i++) {
                last = Math.min(last, lens[a[i]]+start-1);
                if(i > last)
                    break;
                maxLen[start]++;
            }
        }
        long mod = (int)1e9+7;
        long[] ways = new long[n+3];
        int[] min = new int[n+3];
        ways[0] = 1;
        int MAX = 1_000_000;
        Arrays.fill(min, MAX);
        min[0] = 0;
        for (int from = 0; from < n; from++) {
            for (int i = 1; i <= Math.min(maxLen[from], n-from); i++) {
                ways[from+i] = (ways[from+i] + ways[from])%mod;
                min[from+i] = Math.min(min[from+i], min[from]+1);
            }
        }
        out.println(ways[n]);
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, maxLen[i]);
        }
        out.println(max);
        out.println(min[n]);

    }
}
