package codeforces.r551;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int[] r = new int[n+1];
        int[] c = new int[n+1];
        for (int i = 1; i < n; i++) {
            out.printf("? %d %d %d %d%n", 1, 1, i, n);
            out.flush();
            r[i] = in.ni();
        }
        for (int i = 1; i < n; i++) {
            out.printf("? %d %d %d %d%n", 1, 1, n, i);
            out.flush();
            c[i] = in.ni();
        }
        int r1 = -1, r2 = -1;
        for (int i = 1; i <= n; i++) {
            if(r[i] %2 == 1 &&r[i-1]%2 == 0)
                r1 = i;
            if(r[i] %2 == 0 &&r[i-1]%2 == 1)
                r2 = i;
        }
        int c1 = -1, c2 = -1;
        for (int i = 1; i <= n; i++) {
            if(c[i] %2 == 1 &&c[i-1]%2 == 0)
                c1 = i;
            if(c[i] %2 == 0 &&c[i-1]%2 == 1)
                c2 = i;
        }
        if(r1 != -1 && c1 != -1) {
            out.printf("? %d %d %d %d%n", r1, c1, r1, c1);
            out.flush();
            int res = in.ni();
            if(res %2 == 1){
                out.printf("! %d %d %d %d%n", r1, c1, r2, c2);
                out.flush();
            } else {
                out.printf("! %d %d %d %d%n", r1, c2, r2, c1);
                out.flush();
            }
            return;
        } else {
            if(c1 == -1) {
                int left = 1, right = n;
                while(left<right){
                    int mid = (left+right)/2;
                    out.printf("? %d %d %d %d%n", r1, 1, r1, mid);
                    out.flush();
                    int res = in.ni();
                    if(res %2 == 0){
                        left = mid+1;
                    } else{
                        right = mid;
                    }
                }
                out.printf("! %d %d %d %d%n", r1, right, r2, right);
                out.flush();
            } else {
                int left = 1, right = n;
                while(left<right){
                    int mid = (left+right)/2;
                    out.printf("? %d %d %d %d%n", 1, c1, mid, c1);
                    out.flush();
                    int res = in.ni();
                    if(res %2 == 0){
                        left = mid+1;
                    } else{
                        right = mid;
                    }
                }
                out.printf("! %d %d %d %d%n", right, c1, right, c2);
                out.flush();

            }
        }
    }
}
