package codeforces.apr2019;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class A {
    int[] a;
    int go(int from , int to){
        if(to == from)
            return 1;
        if(to <= from)
            throw new RuntimeException();

        boolean sortedUp = true;
        for (int i = from+1; i <= to; i++) {
            if(a[i] < a[i-1])
                sortedUp = false;
        }
        if(sortedUp)
            return to-from+1;
        int mid = (from + to+1)/2;
        int left = go(from, mid-1);
        int right = go(mid, to);
        return Math.max(left, right);
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        a = in.na(n);
        if(n <= 1)
            out.println(n);
        else
            out.println(go(0, n-1));

    }
}
