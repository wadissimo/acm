package codeforces.r445;

import chelper.io.FastScanner;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int SIGMA = 26;
        List<String>[] from = new List[SIGMA];
        for (int i = 0; i < SIGMA; i++) {
            from[i] = new
                    LinkedList<>();
        }
        int[] cnts = new int[SIGMA];
        boolean[] used = new boolean[SIGMA];
        boolean[] mid = new boolean[SIGMA];
        for (int i = 0; i < n; i++) {
            String s = in.ns();
            from[s.charAt(0) - 'a'].add(s);
            Arrays.fill(cnts, 0);
            for (int j = 0; j < s.length(); j++) {
                int c = s.charAt(j) - 'a';
                if (cnts[c] > 0) {
                    out.println("NO");
                    return;
                }
                cnts[c]++;
                used[c] = true;
                if (j > 0)
                    mid[c] = true;
            }
        }

        boolean[] usedStart = new boolean[SIGMA];

        String ans = "";
        for (int i = 0; i < SIGMA; i++) {
            int first = -1; // find start
            if (ans.length() > i) {
                first = ans.charAt(i) - 'a';
            } else {
                boolean done = true;
                for (int j = 0; j < SIGMA; j++) {
                    if(used[j] && !usedStart[j]){
                        done = false;
                        break;
                    }
                }
                if(done){
                    out.println(ans);
                    return;
                }
                for (int j = 0; j < SIGMA; j++) {
                    if (!usedStart[j] && from[j].size() > 0 && !mid[j]) {
                        first = j;
                        break;
                    }
                }
                if (first == -1) {
                    out.println("NO");
                    return;
                }
            }
//            System.out.println("(first + 'a') = " + (char) (first + 'a'));
            if(usedStart[first]){
                out.println("NO");
                return;
            }
            usedStart[first] = true;
            String res;
            if (ans.length() <= i)
                res = "";
            else
                res = ans.substring(i);
            for (String s : from[first]) {
                if (res.length() == 0) {
                    res = s;
                    continue;
                }
                if (s.length() > res.length()) {
                    if (!s.startsWith(res)) {
                        out.println("NO");
                        return;
                    }
                    res = s;
                } else {
                    if (!res.startsWith(s)) {
                        out.println("NO");
                        return;
                    }
                }
            } // extend
//            System.out.println("res = " + res);
            if (res.length() + i > SIGMA) {
                out.println("NO");
                return;
            }
            if (ans.length() > 0)
                ans = ans.substring(0, i);
            ans = ans + res;
//            System.out.println("ans = " + ans);
        }
        out.println(ans);
    }
}
