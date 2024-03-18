package codeforces.r515;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.TreeSet;

public class TaskB {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int r = in.ni();
        int[] a = in.na(n);
        TreeSet<Integer> index = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            if(a[i] == 1)
                index.add(i);
        }
        int i = 0;
        int ans = 0;
        while(i<n){
            Integer next = index.lower(i + r);
            if(next == null || next < i){
                if(i==0)
                    break;
                else{
                    Integer prev = index.lower(i);
                    if(prev == null || prev + r <=i){
                        break;
                    } else {
                        i = prev + r;
                    }
                }
            } else {
                i = next +r;
            }
            ans++;
        }
        if(i<n)
            out.println(-1);
        else
            out.println(ans);

    }
}
