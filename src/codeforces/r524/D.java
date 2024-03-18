package codeforces.r524;

import chelper.io.FastScanner;
import java.io.PrintWriter;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int T = in.ni();
        for (int t = 0; t < T; t++) {
            long n = in.nl(), k = in.nl();
            if(n==2 && k==3){
                out.println("NO");
                continue;
            }

            boolean possible = false;
            long size = n;
            long rem = k;
            for (int i = 0; i <=31 && size > 0 && rem > 0; i++) {
                long splits = 1L<<(i*2);
                //System.out.println("splits = " + splits);
                rem -= splits;
                size--;
            }
            if(rem > 0){
                //System.out.println("rem = " + rem);
                out.println("NO");
                continue;
            }
            long path = 1;
            long i = 0;
            size = n;
            long ans = 0;

            while(path <= k && size > 0) {
                //System.out.printf("path=%d k=%d size=%d%n", path, k, size);
                k -= path;
                path = (1L<<i+2)-1;
                size--;
                i++;
            }

            //System.out.printf("size=%d k=%d%n", size, k);
            out.println("YES " + size);


        }
    }
}
