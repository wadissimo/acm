package codeforces.r518;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskD {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[]a = in.na(n);
        long [][]d = new long[n][201];
        for (int i = 0; i < n; i++) {
            if(a[i] == -1){
                if(i == 0){
                    for (int j = 1; j < 201; j++) {
                        d[0][j] = 1;
                    }
                } else {
                    for (int j = 1; j < 201; j++) {

                    }
                }
            } else{

            }
        }

    }
}
