package codeforces.r486;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int k = in.ni();
        HashMap<Long, Integer[]> map = new HashMap<>();
        boolean ans = false;
        for (int i = 0; i < k; i++) {
            int n = in.ni();
            int [] a = in.na(n);
            long totalSum = 0;
            for (int j = 0; j < n; j++) {
                totalSum += a[j];
            }
            for (int j = 0; j < n; j++) {
                Integer[] pair = map.get(totalSum - a[j]);
                if(pair != null &&!ans){
                    out.println("YES");
                    out.print(i+1);out.print(" ");out.println(j+1);
                    out.print(pair[0]);out.print(" ");out.println(pair[1]);
                    ans = true;
                }
            }
            for (int j = 0; j < n; j++) {
                map.put(totalSum-a[j], new Integer[]{i+1, j+1});
            }
        }
        if(!ans)
            out.println("NO");
    }
}
