package codeforces.r550;

import chelper.io.FastScanner;
import common.ArrayUtils;

import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.TreeSet;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] a = in.na(n);
        if(n > 10000)
            ArrayUtils.randomShuffle(a);
        Arrays.sort(a);
        //System.out.println(Arrays.toString(a));
        LinkedList<Integer> up = new LinkedList<>();
        TreeSet<Integer> down = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            if(up.isEmpty() || up.peekLast() < a[i]){
                up.addLast(a[i]);
            } else {
                if(down.contains(a[i])){
                    out.println("NO");
                    return;
                } else{
                    down.add(a[i]);
                }
            }
        }
        out.println("YES");
        out.println(up.size());
        for (Integer num : up) {
            out.print(num + " ");
        }
        out.println();
        out.println(down.size());
        for (Integer num : down) {
            out.print(num + " ");
        }
        out.println();
    }
}
