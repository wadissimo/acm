package codeforces.r487;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    int fill(char[] row, char base, char fill, int num){
        int n = row.length;
        row[0] = row[n-1] = base;
        for (int i = 1; i < n - 1; i++) {
            if(i%2 == 1 && num > 0){
                row[i] = fill;
                num--;
            } else {
                row[i] = base;
            }
        }
        return num;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int a = in.ni(), b = in.ni(), c = in.ni(), d = in.ni();
        a--;
        b--;
        char[][] ans = new char[50][50];
        int row = 0;
        while(b > 0){
            b = fill(ans[row++], 'A', 'B', b);
            fill(ans[row++], 'A', 'A', 0);
        }

        while(c > 0){
            c = fill(ans[row++], 'A', 'C', c);
            fill(ans[row++], 'A', 'A', 0);
        }

        while(d > 0){
            d = fill(ans[row++], 'A', 'D', d);
            fill(ans[row++], 'A', 'A', 0);
        }
        fill(ans[row++], 'B', 'B', 0);
        while(a > 0){
            a = fill(ans[row++], 'B', 'A', a);
            fill(ans[row++], 'B', 'B', 0);
        }
        out.printf("%d %d%n", row, 50);
        for (int i = 0; i < row; i++) {
            out.println(String.valueOf(ans[i]));
        }

    }
}
