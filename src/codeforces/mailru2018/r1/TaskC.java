package codeforces.mailru2018.r1;

import chelper.io.InputReader;
import java.io.PrintWriter;

public class TaskC {
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        int n = in.ni();
        int[]l = in.na(n);
        int[]r = in.na(n);
        int[]s = new int[n];
        int maxS = 0;
        for (int i = 0; i < n; i++) {
            s[i] = l[i]+r[i];
            maxS = Math.max(s[i], maxS);
        }
        int[] values = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = maxS+1-s[i];
        }
        boolean ans = true;
        for (int i = 0; i < n; i++) {
            int lc = 0;
            for (int j = 0; j < i; j++) {
                if(values[j] > values[i])
                    lc++;
            }
            int rc = 0;
            for (int j = i+1; j < n; j++) {
                if(values[j] > values[i])
                    rc++;
            }
            if(lc != l[i] || rc != r[i]){
                ans = false;
                break;
            }
        }
        if(ans){
            out.println("YES");
            for (int i = 0; i < n; i++) {
                out.print(values[i]);
                if(i!=n-1)
                    out.print(' ');
            }
            out.println();
        }else{
            out.println("NO");
        }


    }
}
