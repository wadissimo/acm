package codeforces.r532;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;
import java.util.List;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), m = in.ni();
        int[] a = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = in.ni()-1;
        }
        LinkedList<Integer>[] qs = new LinkedList[n];
        for (int i = 0; i < n; i++) {
            qs[i] = new LinkedList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            qs[a[i]].add(i);
        }
        int i = 0;
        int[] ans = new int[m];
        boolean search = true;
        while(search){
            int maxInd = 0;
            for (int j = 0; j < n; j++) {
                if(qs[j].isEmpty()){
                    search = false;
                    break;
                }
                maxInd = Math.max(qs[j].pop(), maxInd);
            }
            if(search)
                ans[maxInd] = 1;
        }
        for (int j = 0; j < m; j++) {
            out.print(ans[j]);
        }
        out.println();

    }
}
