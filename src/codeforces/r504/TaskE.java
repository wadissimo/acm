package codeforces.r504;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class TaskE {
    boolean check(FastScanner in, PrintWriter out, int r, int c, int tr, int tc){
        out.println("? " + r + " " + c + " " + tr + " " + tc);
        out.flush();
        String res = in.ns();
        return "YES".equals(res);
    }
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int r = 1; int c = 1;
        char[] dirs = new char[2*n-2];
        int []pr = new int[2*n-1];
        int []pc = new int[2*n-1];
        int pi;
        pr[0] = pc[0] = 1;
        for (pi = 0; pi < n-1; pi++) {
            if(check(in, out, r+1, c, n,n)){
                r++;
                dirs[pi] = 'D';
            } else {
                c++;
                dirs[pi] = 'R';
            }
            pr[pi+1] = r;
            pc[pi+1] = c;
        }
        r = n; c= n;
        int last = 2*n-3;
        for (pi = n-2; pi >= 0 ; pi--) {
            if(check(in, out, pr[pi], pc[pi], r, c-1)){
                dirs[last] = 'R';
                c--;
            } else {
                dirs[last] = 'D';
                r--;
            }
            last--;
        }
        out.println("! " + String.valueOf(dirs));
    }
}
