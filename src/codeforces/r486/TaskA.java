package codeforces.r486;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class TaskA {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n=in.ni();
        int k =in.ni();
        int[] a = in.na(n);
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < n; i++) {
            set.put(a[i], i);
        }
        if(set.size()<k)
            out.println("NO");
        else{
            out.println("YES");
            for (Integer ind : set.values()) {
                k--;
                out.print(ind+1);
                if(k!=0)
                    out.print(" ");
                else{
                    out.println();
                    break;
                }
            }
        }


    }
}
