package codeforces.mailru2018.r2;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class B {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(); int m = in.ni(); long l = in.ni();
        long[] a = in.nal(n);
        int cnt = 0;
        if(a[0] > l)
            cnt++;
        for (int i = 1; i < n; i++) {
            if(a[i-1] <= l && a[i] > l){
                cnt++;
            }
        }
        for (int i = 0; i < m; i++) {
            int op = in.ni();
            if(op == 0)
                out.println(cnt);
            else{
                int p = in.ni()-1;
                long d = in.ni();
                if(a[p] <= l){
                    a[p] += d;
                    if(a[p] > l){
                        if((p == 0 || a[p-1] <= l) && (p == n-1 || a[p+1] <= l)){
                            cnt++;
                        }
                        if(p > 0 && p < n-1 && a[p-1] > l && a[p+1] > l)
                            cnt--;
                    }
                }
            }
        }
    }
}
