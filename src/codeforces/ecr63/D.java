package codeforces.ecr63;

import chelper.io.FastScanner;
import java.io.PrintWriter;
import java.util.Arrays;

public class D {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        long MAX = 1_000_000_000_000L;
        int n = in.ni();int x = in.ni();
        int[] a = in.na(n);
        long sum = 0;
        long beauty = 0;
        long[] total = new long[n];
        long[] bestLeft = new long[n];
        for (int i = 0; i < n; i++) {
            if(i > 0){
                total[i] = total[i-1];
            }
            total[i] += a[i];
            sum+=a[i];
            if(sum < 0){
                sum = 0;
            }
            beauty = Math.max(beauty, sum);
            bestLeft[i] = beauty;
        }
        System.out.println("Arrays.toString(bestLeft) = " + Arrays.toString(bestLeft));
        System.out.println("Arrays.toString(total) = " + Arrays.toString(total));
//        System.out.println("beauty = " + beauty);
        if(x > 0) {
            out.println(beauty*x);
        } else {
            long[] bestRight = new long[n+1];
            for (int i = n-1; i >= 0 ; i--) {
                if(i == n-1)
                    bestRight[i] = total[i];
                else
                    bestRight[i] = Math.max(total[i], bestRight[i+1]);
            }
//            System.out.println("Arrays.toString(bestRight) = " + Arrays.toString(bestRight));
            long min = 0;
            int from = 0;
            sum = 0;
            long best = beauty;
            for (int i = 0; i < n; i++) {
                sum+=a[i];
                if(sum >= 0){
                    from = i+1;
                    sum = 0;
                }
                System.out.println("i = " + i);
                System.out.println("sum = " + sum);
                if(sum < 0){
                    long cur = bestLeft[from] + sum*x;
                    long suffix = (bestRight[i+1]-total[i]);
                    System.out.println("bestLeft = " + bestLeft[from]);
                    System.out.println("sum = " + sum);
                    System.out.println("cur = " + cur);
                    System.out.println("suffix = " + suffix);
                    if(i == n-1)
                        suffix = 0;
                    best = Math.max(best,  cur +suffix);
                }
                min = Math.min(min, sum);
            }
//            System.out.println("best = " + best);
            if(best > beauty)
                out.println(best);
            else
                out.println(beauty);
        }
    }
}
