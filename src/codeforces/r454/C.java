package codeforces.r454;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int m = in.ni();
        int N = 26;
        boolean[] wrong = new boolean[N];
        int[] cnt = new int[N];
        int curCnt = 0;
        char[] ops = new char[m];
        String[] ss = new String[m];
        int total = 0;
        for (int i = 0; i < m; i++) {
            ops[i] = in.ns().charAt(0);
            if(ops[i] == '?' || ops[i] == '!')
                total++;
            ss[i] = in.ns();
        }
        total--;
        int checks = 0;
        for (int i = 0; i < m-1; i++) {
            char op = ops[i];
            String s = ss[i];
            if (op == '.') {
                for (int j = 0; j < s.length(); j++) {
                    wrong[s.charAt(j) - 'a'] = true;
                }
            } else if (op == '!') {
                curCnt++;
                for (int j = 0; j < s.length(); j++) {
                    if(!wrong[s.charAt(j)-'a'] && cnt[s.charAt(j)-'a'] == curCnt-1)
                        cnt[s.charAt(j)-'a'] = curCnt;
                }
            } else if(op == '?'){
                char c = s.charAt(0);
                checks++;
                wrong[c-'a'] = true;
            }

            int check = 0;
            for (int j = 0; j < N; j++) {
                if (!wrong[j] && cnt[j] == curCnt)
                    check++;
            }
            if (check == 1) {
//                System.out.println("curCnt = " + curCnt);
//                System.out.println("checks = " + checks);
//                System.out.println("total = " + total);
                out.println(total-curCnt-checks);
                return;
            }
        }
        out.println(0);

    }
}
