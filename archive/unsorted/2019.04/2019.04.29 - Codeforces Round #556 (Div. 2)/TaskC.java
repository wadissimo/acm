package main;

import chelper.io.FastScanner;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.ArrayList;

public class TaskC {
    public void solve(int testNumber, FastScanner in, PrintWriter out) {
        int n = in.ni();
        int cnt1 = 0, cnt2 = 0;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = in.ni();
            if(a[i] == 1)
                cnt1++;
            else cnt2++;
        }
        if(cnt1 == 0 || cnt2 == 0){
            for (int i = 0; i < n; i++) {
                out.print(a[i] + " ");
            }
        } else {
            int MAX = 500_000;
            int[] lp = new int[MAX+1];
            ArrayList<Integer> primes = new ArrayList<>();
            IntegerUtils.sieve(MAX, primes, lp);
            out.print("2 1 ");
            cnt1--; cnt2--;
            for (int i = 2; i < primes.size(); i++) {
                int dif = primes.get(i) - primes.get(i-1);
                while(cnt2 > 0 && dif > 0){
                    out.print("2 ");
                    cnt2--;
                    dif -=2;
                }
                while(cnt1 > 0 && dif > 0){
                    out.print("1 ");
                    cnt1--;
                    dif --;
                }
                if(dif > 0)
                    break;
                if(cnt1 == 0 && cnt2 == 0)
                    break;
            }


        }
    }
}
