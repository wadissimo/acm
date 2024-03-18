package main;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class TaskD {
    boolean[] used;
    boolean color(String s, int depth){
        Arrays.fill(used, false);
        int cur = 0;
        int N = s.length();
        for (int i = 0; i < N; i++) {
            if(s.charAt(i) == '('){
                if(cur < depth){
                    used[i] = true;
                    cur++;
                }
            } else {
                if(cur > 0){
                    cur--;
                    used[i] = true;
                }
            }
        }
        cur = 0;
        for (int i = 0; i < N; i++) {
            if(!used[i]){
                if(s.charAt(i) == '('){
                    cur++;
                    if(cur > depth)
                        return false;
                } else {
                    cur--;
                    if(cur < 0)
                        throw new RuntimeException();
                }
            }
        }
        return true;
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int N = in.ni();
        String s = in.ns();
        int left = 1, right = N/2;
        used = new boolean[N];
        while(left < right){
            int mid = (right+left)/2;
            if(!color(s, mid)) {
                left = mid+1;
            } else {
                right = mid;
            }
        }
        color(s, left);
        for (int i = 0; i < N; i++) {
            out.print(used[i]?'1':'0');
        }
        out.println();
    }
}
