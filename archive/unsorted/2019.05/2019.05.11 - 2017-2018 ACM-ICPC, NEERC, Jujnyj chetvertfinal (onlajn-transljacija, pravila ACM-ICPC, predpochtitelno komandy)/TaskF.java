package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskF {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni();
        String[] strs = new String[N];
        for (int i = 0; i < N; i++) {
            strs[i] = in.ns();
        }
        String [] res = new String[N];
        for (int i = 0; i < N; i++) {
            StringBuilder sb = new StringBuilder();
            boolean h = false;
            for(int j = strs[i].length()-1; j >= 0; j--){
                char c = strs[i].charAt(j);
                if(c != 'k'){
                    h = false;
                }
                if(c == 'u'){
                    sb.append("oo");
                } else if(c == 'h'){
                    h = true;
                    sb.append('h');
                } else if(c == 'k'){
                    if(!h){
                        sb.append('k');
                    }
                } else {
                    sb.append(c);
                }
            }
            res[i] = sb.reverse().toString();
        }
        Arrays.sort(res);
        int ans = 1;
        for (int i = 1; i < N; i++) {
            if(!res[i].equals(res[i-1]))
                ans++;
        }
        out.println(ans);

    }
}
