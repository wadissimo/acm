package codeforces.ecr59;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class C {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni(), k = in.ni();
        int[] a = in.na(n);
        int[] b = new int[n];
        String s = in.ns();
        int bi = 0;
        b[bi++] = a[0];
        long ans = 0;
        Random r = new Random();
        for (int i = 1; i <= n; i++) {
            if(i == n || s.charAt(i) != s.charAt(i-1)){
                if(bi > 1000){
                    for (int j = 0; j < bi; j++) {
                        int x = r.nextInt(bi), y = r.nextInt(bi-1);
                        if(y >= x) y++;
                        int t = b[x]; b[x] = b[y]; b[y] = t;
                    }
                }
                Arrays.sort(b, 0, bi);
                for (int j = bi-1; j >=0&&j >= bi-k ; j--) {
                    ans += b[j];
                }
                bi = 0;
                if(i == n) break;
            }
            b[bi++] = a[i];
        }
        out.println(ans);
    }
}
