package codeforces.r301;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = Integer.parseInt(new StringTokenizer(in.readLine()).nextToken());
        String s1 = in.readLine();
        String s2 = in.readLine();
        int res = 0;
        for (int i = 0; i < n; i++) {
            int a = s1.charAt(i) - '0';
            int b = s2.charAt(i) - '0';
            if(a < b) {
                int t = a;
                a = b;
                b = t;
            } //a >= b
            res += Math.min(Math.abs(a-b), Math.abs(10+b-a));

        }
        out.println(res);

    }
}
