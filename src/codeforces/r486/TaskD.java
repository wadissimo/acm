package codeforces.r486;

import chelper.io.InputReader;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;

public class TaskD {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        long[] a = in.nal(n);
        HashMap<Long,Integer> map = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            map.put(a[i], 1);
        }
        long ans0 = 0;
        long ans1 = -1;
        boolean found = false;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <=31; j++) {
                long x = a[i] + (1<<j);
                long y = a[i] - (1<<j);
                if(map.containsKey(x)){
                    if(map.containsKey(y)) {
                        out.println(3);
                        out.println(y + " " + a[i] + " " + x);
                        found = true;
                        break;
                    }else{
                        ans0 = a[i];
                        ans1 = x;
                    }
                }else{
                    if(map.containsKey(y)) {
                        ans0 = a[i];
                        ans1 = y;
                    }
                }
            }
            if(found)
                break;
        }
        if(!found){
            if(ans1 != -1){
                out.println(2);
                out.println(ans0+" "+ans1);
            } else {
                out.println(1);
                out.println(a[0]);
            }
        }

    }
}
