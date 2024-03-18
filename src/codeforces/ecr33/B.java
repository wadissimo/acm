package codeforces.ecr33;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.LinkedList;

public class B {

    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int max = 1;
        HashSet<Integer> set = new HashSet<>();
        int cur = 1;
        int k = 0;
        while(cur <= n){
            set.add(cur);
            k++;
            cur = ((1<<k)-1) << (k-1);
        }
        for (int div = 1; div*div <= n ; div++) {
            if(n%div == 0){
                if(set.contains(div))
                    max = Math.max(div, max);
                if(div*div < n){
                    if(set.contains(n/div))
                        max = Math.max(n/div, max);
                }
            }
        }
        out.println(max);
    }
}
