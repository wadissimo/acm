package codeforces.ecr53;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskB {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int a[] = in.na(n);
        int b[] = in.na(n);
        int ind[] = new int[n];
        for (int i = 0; i < n; i++) {
            ind[a[i]-1] = i;
        }
        int cur = -1;
        for (int i = 0; i < n; i++) {
            int bi = b[i]-1;
            if(ind[bi] > cur){
                out.print((ind[bi]-cur) + " ");
                cur = ind[bi];
            } else {
                out.print("0 ");
            }

        }
        out.println();
    }
}
