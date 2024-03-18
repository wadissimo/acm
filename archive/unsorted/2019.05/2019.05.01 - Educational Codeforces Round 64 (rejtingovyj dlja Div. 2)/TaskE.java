package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.TreeSet;

public class TaskE {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] p = in.na(n);
        int[] idx = new int[n+1];
        for (int i = 0; i < n; i++) {
            idx[p[i]] = i;
        }
        TreeSet<Integer> blocked = new TreeSet<>();
        blocked.add(-1);
        blocked.add(n);
        int ans = 0;
        for(int max = n; max>0;--max){
            int pos = idx[max];
            int right = blocked.higher(pos);
            int left = blocked.lower(pos);
//            System.out.print("max = " + max);
//            System.out.print(" left = " + left);
//            System.out.println(" right = " + right);
            if(right-pos-1 < pos-left-1) {
                for (int i = pos+1; i < right ; i++) {
                    if(p[i]> max)
                        throw new RuntimeException();
                    int pairPos = idx[max-p[i]];
                    if(left < pairPos && pairPos < pos){
                        ans++;
                    }
                }
            } else {
                for (int i = left+1; i < pos ; i++) {
                    if(p[i] > max)
                        throw new RuntimeException();
                    int pairPos = idx[max-p[i]];
                    if(pos < pairPos && pairPos < right){
                        ans++;
                    }
                }
            }
            blocked.add(pos);
        }
        out.println(ans);
    }
}
