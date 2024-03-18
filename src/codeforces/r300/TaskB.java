package codeforces.r300;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {


        int n = in.ni();
        if(n == 1000000) {
            out.println(1);
            out.println(n);
            return;
        }
        String s = String.valueOf(n);
        int d[][] = new int[9][s.length()];
        for (int i = 0; i < s.length(); i++) {
            int a = s.charAt(i) - '0';
            for (int j = 0; j < a; j++) {
                d[j][i] = 1;
            }
        }
        int c = 0;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 9; i++) {
            boolean trailing0 = true;
            StringBuilder num = new StringBuilder();
            for (int j = 0; j < s.length(); j++) {
                if(trailing0 && d[i][j] == 0) {
                    continue;
                }
                trailing0 = false;
                num.append(d[i][j]);
            }
            if(!trailing0) {
                sb.append(num).append(" ");
                c++;
            }
        }
        out.println(c);
        out.println(sb);
    }
}
