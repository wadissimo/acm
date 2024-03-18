package codeforces.all;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.TreeMap;

public class R521_E {

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        TreeMap<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < n; i++) {
            map.put(a[i], map.getOrDefault(a[i], 0)+1);
        }
        int[] cnts = new int[map.size()];
        int ci = 0;
        for (int value : map.values()) {
            cnts[ci++] = value;
        }
        Arrays.sort(cnts);
        //System.out.println(Arrays.toString(cnts));
        int ans = 0;
        for (int len = 1; len < 20 && len <= ci; len++) {
            int start = 2000000;
            int resLen = 0;
            for (int i = ci-1; i >= ci-len ; i--) {
                resLen++;
                start /= 2;
                if(cnts[i] < start)
                    start = cnts[i];
                if(start == 1)
                    break;
            }

            int sum = start*((1<<resLen) - 1);
            //System.out.printf("%d %d %d%n", resLen, start, sum);
            ans = Math.max(sum, ans);
        }
        out.println(ans);

    }
}
