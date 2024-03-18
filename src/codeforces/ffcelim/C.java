package codeforces.ffcelim;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            int n = in.ni();
            int from = 2, to = n;
            out.print("1 "+(n-1) + " 1 ");
            for (int i = 2; i <= n; i++) {
                out.print(i + " ");
            }
            out.println();
            out.flush();
            int best = in.ni();
            if(best == -1)
                return;
            while(from < to){
                int mid = (from+to)/2;
                out.print("1 "+(mid-from+1) + " 1 ");
                for (int i = from; i <= mid; i++) {
                    out.print(i + " ");
                }
                out.println();
                out.flush();
                int res = in.ni();
                if(res == -1)
                    return;
                if(res < best){
                    from = mid+1;
                } else
                    to = mid;
            }
            out.print("1 "+(n-1) + " " + from + " ");
            for (int i = 1; i <= n; i++) {
                if(i != from)
                    out.print(i + " ");
            }
            out.println();
            out.flush();
            int res = in.ni();
            if(res == -1)
                return;
            out.println("-1 " + res);
            out.flush();
        }
    }
}
