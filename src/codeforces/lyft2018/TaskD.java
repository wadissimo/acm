package codeforces.lyft2018;

import chelper.io.InputReader;
import common.IntegerUtils;

import java.io.PrintWriter;
import java.util.ArrayList;

public class TaskD {
    static long div(ArrayList<Integer> pr, long n){
        for (Integer p : pr) {
            if(p >= n)
                return n;
            if(n%p == 0){
                return p;
            }
        }
        throw new RuntimeException();
    }
    public void solve(int testNumber, InputReader in, PrintWriter out) {
        ArrayList<Integer> pr = new ArrayList<>(98000);
        int[] lp = new int[1260001];
        IntegerUtils.sieve(1260000, pr, lp);
        int n = in.ni();
        long ans = 1;
        for (int i = 0; i < n; i++) {
            long a = in.nl();
            int di = 0;
            long sqrt = (long)Math.sqrt(a);
            if(sqrt*sqrt==a)
                di = 3;
            else{
                long div1 = div(pr, a);
                if(div1 == a){
                    di = 4;
                }else{
                    a /= div1;
                    long div2 = div(pr, a);
                    
                }
            }

            while(true){
                long div = div(pr, a);
                di++;
                if(div == a)
                    break;
                else
                    a /= div;
            }
            ans *= di;
            ans %= 998244353;
        }
        out.println(ans);
    }
}
