package codeforces.avito2018.cool;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.LinkedList;

public class E {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni()/2;
        long[] x = in.nal(n);
        boolean possible = true;
        long[] ans = new long[n];
        long[]a = new long[n];
        long[]b = new long[n];
        for (int i = 0; i < n; i++) {
            long after = Integer.MAX_VALUE;
            long before = -1;
            for (long div = 1; div*div < x[i]; div++) {
                if(x[i] % div == 0){
                    if(div %2 == (x[i]/div)%2){
                        long curBefore = (x[i]/div - div)/2;
                        long curAfter = (x[i]/div + div)/2;
                        if(i == 0 || curBefore > b[i-1]){
                            if(curAfter < after){
                                after = curAfter;
                                before = curBefore;
                            }
                        }
                    }
                }
            }
            if(before <= 0){
                possible = false;
                break;
            }
            a[i] = before;
            b[i] = after;
            if(i == 0){
                ans[i] = a[i]*a[i];
            } else{
                if(a[i] <= b[i-1]){
                    possible = false;
                    break;
                }
                ans[i] = (a[i]-b[i-1])*(a[i] + b[i-1]);
            }



        }
        if(!possible){
            out.println("No");
        } else{
            out.println("Yes");
            for (int i = 0; i < n; i++) {
                if(ans[i] == 0){
                    throw new RuntimeException();
                }
                out.print(ans[i] + " " + x[i] + " ");
            }
            out.println();
        }




    }
}
